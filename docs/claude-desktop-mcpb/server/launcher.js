const { spawn } = require("node:child_process");
const { existsSync } = require("node:fs");
const path = require("node:path");

// This small STDIO bridge lets Claude Desktop launch the already-built Java MCP server.
// Keep stdout exclusively for MCP JSON-RPC; diagnostics belong on stderr.

const javaExecutable = process.env.BIBLIOTECA_JAVA_EXECUTABLE;
const serverJar = process.env.BIBLIOTECA_SERVER_JAR;
const dataDirectory = process.env.APP_DATA_DIR;

function fail(message) {
  process.stderr.write(`[biblioteca-digital] ERRO: ${message}\n`);
  process.exit(2);
}

if (!javaExecutable || !serverJar || !dataDirectory) {
  fail("Configuração incompleta. Confira java_executable, server_jar e app_data_dir nas opções da extensão.");
}

if (!existsSync(javaExecutable)) {
  fail(`java.exe não encontrado: ${javaExecutable}`);
}

if (!existsSync(serverJar)) {
  fail(`JAR do servidor não encontrado: ${serverJar}. Gere-o com o perfil Maven server antes de iniciar a extensão.`);
}

if (!existsSync(path.join(path.dirname(serverJar), "libs"))) {
  fail(`A pasta libs não existe ao lado do JAR: ${path.dirname(serverJar)}. Gere novamente o artefato do servidor sem mover seus arquivos.`);
}

if (!existsSync(dataDirectory)) {
  fail(`Pasta data não encontrada: ${dataDirectory}`);
}

const child = spawn(javaExecutable, ["-jar", serverJar], {
  cwd: path.dirname(serverJar),
  env: {
    ...process.env,
    APP_DATA_DIR: dataDirectory,
    SOLR_ENABLED: process.env.SOLR_ENABLED || "false"
  },
  stdio: ["pipe", "pipe", "pipe"],
  windowsHide: true
});

// Forward MCP protocol bytes unchanged.
process.stdin.pipe(child.stdin);
child.stdout.pipe(process.stdout);
child.stderr.pipe(process.stderr);

child.on("error", (error) => {
  process.stderr.write(`[biblioteca-digital] Não foi possível iniciar o servidor Java: ${error.message}\n`);
  process.exitCode = 1;
});

child.on("close", (code, signal) => {
  process.stdin.unpipe(child.stdin);
  process.stdin.pause();
  process.exitCode = code ?? (signal ? 1 : 0);
});

for (const signal of ["SIGINT", "SIGTERM"]) {
  process.once(signal, () => {
    if (!child.killed) child.kill(signal);
  });
}
