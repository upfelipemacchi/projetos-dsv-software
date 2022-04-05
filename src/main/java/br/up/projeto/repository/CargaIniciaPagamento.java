package br.up.projeto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.Pagamento;

@Configuration
public class CargaIniciaPagamento {

    private static final Logger log = LoggerFactory.getLogger(CargaIniciaPagamento.class);

    @Bean CommandLineRunner 
    iniciarDb(PagamentoRepository repository) {
        return args -> {
            log.info("Carregando... " + repository.save(new Pagamento("Gabriel", 1.00)));
            log.info("Carregando... " + repository.save(new Pagamento("Felipe", 2.00)));
        };
    }
}
