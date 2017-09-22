package br.com.mk.springscheduling.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LogJob {

    private static final Logger LOG = LoggerFactory.getLogger(LogJob.class);

    @Scheduled(fixedRate = 5000)
    public void gravarArquivoLogs() throws IOException {
        LOG.info("-------------- CRIANDO ARQUIVO DE LOGS[INICIO] --------------");
        String TEXTO = "linha-" + System.currentTimeMillis() + "\n";
        LOG.info("LINHA: " + TEXTO);
        Path path = Files.write(Paths.get("LOG-" + System.currentTimeMillis() + ".txt"), TEXTO.getBytes());
        LOG.info("FILE NAME: " + path.getFileName());
        LOG.info("FILE SYSTEM: " + path.getFileSystem());
        LOG.info("FILE PARENT: " + path.getParent());
        LOG.info("-------------- CRIANDO ARQUIVO DE LOGS[FIM] --------------");
    }
}
