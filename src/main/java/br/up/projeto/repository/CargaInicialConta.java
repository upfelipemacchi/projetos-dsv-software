package br.edu.up.projeto.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.up.projeto.domain.Conta;

@Configuration
public class CargaInicialConta {
    
    private static final Logger log = LoggerFactory.getLogger(CargaInicialConta.class);

    @Bean CommandLineRunner
    iniciarDb(ContaRepository repository){
        return args -> {
            log.info("Carregando..." + repository.save(new Conta("Real", null, null, null)));
            log.info("Carregando..." + repository.save(new Conta("Euro", null, null, null)));
        };

    }
}
