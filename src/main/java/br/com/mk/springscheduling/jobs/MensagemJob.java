package br.com.mk.springscheduling.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MensagemJob {

    private static final Logger log = LoggerFactory.getLogger(MensagemJob.class);

    /*
        @Scheduled deve ser anotado em métodos dentro de qualquer classe anotada com @Component.
        @Scheduled(fixedRate = 5000): Especifica um intervalo entre as invocações a partir do inicio de cada invocação.
     */
    @Scheduled(fixedRate = 5000)
    public void task1(){
        log.info("Executando task 1 - " + LocalDateTime.now());
    }

    /*
        @Scheduled(fixedDelay = 5000): Especifica um intervalo entre as invocações a partir da conclusão da tarefa
        anterior.
     */
    @Scheduled(fixedDelay = 5000)
    public void task2(){
        log.info("Executando task 2 - " + LocalDateTime.now());
    }

    /*
        @Scheduled(initialDelay = 1000, fixedRate = 5000): Especifica um delay inicial antes e executar a tarefa.
     */
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void task3(){
        log.info("Executando task 3 - " + LocalDateTime.now());
    }
}
