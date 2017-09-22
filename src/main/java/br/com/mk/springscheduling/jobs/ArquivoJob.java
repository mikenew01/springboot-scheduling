package br.com.mk.springscheduling.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ArquivoJob {

    private static final Logger LOG = LoggerFactory.getLogger(ArquivoJob.class);

    /**
     * Determina o nome principal do diretorio.
     */
    private final String DIRETORIO = "arquivos";

    /**
     * Determina a extensão do arquivo.
     */
    private final String EXTENSAO = ".txt";

    /**
     * Determina a URL do path para o diretorio especificado.
     */
    private final Path pathDiretorio = Paths.get(DIRETORIO);

    /**
     * Determina o nome principal do arquivo.
     */
    private String NOME_ARQUIVO = "arquivo";


    /**
     * Gera arquivos com conteúdo em cada interação do Job.
     * OBS: Pode ser alterado para criar um arquivo por dia e com data.
     *
     * @throws IOException
     */
    @Scheduled(fixedRate = 5000)
    public void gerarArquivo() throws IOException {
        LOG.info("==================== Iniciando arquivo ====================");

        //Define nome do direto + arquivo (arquivo com nome aleatorio).
        String DIRETORIO_ARQUIVO = new StringBuilder()
                .append(DIRETORIO)
                .append("/")
                .append(NOME_ARQUIVO)
                .append("-")
                .append(UUID.randomUUID())
                .append(EXTENSAO)
                .toString();

        Path pathArquivo = Paths.get(DIRETORIO_ARQUIVO);

        //Recuperar lista do banco
        List<String> linhas = Arrays.asList("Testando: " + System.currentTimeMillis());

        if (Files.exists(pathDiretorio)) {
            if (Files.exists(pathArquivo)) {
                List<String> lines = Files.readAllLines(pathArquivo, StandardCharsets.UTF_8);

                if (lines.addAll(linhas))
                    Files.write(pathArquivo, lines);
            } else {
                Files.write(pathArquivo, linhas);
            }
        } else {
            Files.createDirectory(pathDiretorio);
            Files.write(pathArquivo, linhas);
        }
    }
}
