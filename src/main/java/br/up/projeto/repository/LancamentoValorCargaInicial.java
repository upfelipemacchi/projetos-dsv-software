package br.up.projeto.repository;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.up.projeto.domain.LancamentoValor;

import org.slf4j.Logger;

@Configuration
public class LancamentoValorCargaInicial{
    private static final Logger log = (Logger) LoggerFactory.getLogger(LancamentoValor.class);

    @Bean CommandLineRunner
    inciarDb (LancamentoValorRepository repository){
        return args -> {
            log.info("Carregamento..." + repository.save(new LancamentoValor("10/10/10", 15.50, 1, 1, 2)));
        };
    }
}
