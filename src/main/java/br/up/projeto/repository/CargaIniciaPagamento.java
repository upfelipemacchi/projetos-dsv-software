package br.up.projeto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.MeioPagamento;

@Configuration
public class CargaIniciaPagamento {

    private static final Logger log = LoggerFactory.getLogger(CargaIniciaPagamento.class);

    @Bean CommandLineRunner 
    iniciarDb(MeioPagamentoRepository repository) {
        return args -> {
            log.info("Carregando... " + repository.save(new MeioPagamento("Boleto","01", 1.00)));
            log.info("Carregando... " + repository.save(new MeioPagamento("Pix","25", 2.00)));
        };
    }
}
