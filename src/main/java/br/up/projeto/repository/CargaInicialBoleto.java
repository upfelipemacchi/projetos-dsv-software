package br.up.projeto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.Boleto;

@Configuration
public class CargaInicialBoleto {
    
    private static final Logger log = LoggerFactory.getLogger(CargaInicialBoleto.class);

    @Bean CommandLineRunner
    iniciarDb(BoletoRepository repository){
        return args -> {
            log.info("Carregando..." + repository.save(new Boleto("Boleto 1", "Nosso num 1")));
        };
    }
    
}
