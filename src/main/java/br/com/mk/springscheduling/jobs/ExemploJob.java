package br.com.mk.springscheduling.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @@Scheduled deve ser anotado em qualquer metodo dentro de uma classe configurada com @Component, além de ser
 * necessária a anotação @EnabledScheduling na application.
 */
@Service
public class ExemploJob {

    private static final Logger log = LoggerFactory.getLogger(ExemploJob.class);

    /**
        @Scheduled(fixedRate = 5000): Especifica um intervalo entre as invocações a partir do inicio de cada invocação.
     */
    @Scheduled(fixedRate = 5000)
    public void task1() {
        log.info("Executando task 1 - " + LocalDateTime.now());
    }

    /**
        @Scheduled(fixedDelay = 5000): Especifica um intervalo entre as invocações a partir da conclusão da tarefa
        anterior.
     */
    @Scheduled(fixedDelay = 5000)
    public void task2() {
        log.info("Executando task 2 - " + LocalDateTime.now());
    }

    /**
        @Scheduled(initialDelay = 1000, fixedRate = 5000): Especifica um delay inicial antes e executar a tarefa.
     */
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void task3() {
        log.info("Executando task 3 - " + LocalDateTime.now());
    }

    /**
        [minutos] [horas] [dias do mês] [mês] [dias da semana] [usuário] [comando]

        O preenchimento de cada campo é feito da seguinte maneira:
        Minutos: informe números de 0 a 59;
        Horas: informe números de 0 a 23;
        Dias do mês: informe números de 1 a 31;
        Mês: informe números de 1 a 12;
        Dias da semana: informe números de 0 a 7;
     */
    @Scheduled(cron = "*/10 * * * * MON-FRI")
    public void task4() {
        log.info("Executando task 4 - " + LocalDateTime.now());
    }

    /**
        @Scheduled(fixedRateString = "${exemplo.job.fixedRate}"): Parametrização dos valores para scheduled fixedRate
     */
    @Scheduled(fixedRateString = "${exemplo.job.fixedRate}")
    public void task5() {
        log.info("Executando task 5 - " + LocalDateTime.now());
    }

    /**
        @Scheduled(fixedDelayString = "${exemplo.job.fixedDelay}"): Parametrização dos valores para scheduled fixedDelay
     */
    @Scheduled(fixedDelayString = "${exemplo.job.fixedDelay}")
    public void task6() {
        log.info("Executando task 6 - " + LocalDateTime.now());
    }
}
