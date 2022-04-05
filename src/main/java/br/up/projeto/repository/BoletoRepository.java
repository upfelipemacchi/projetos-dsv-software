package br.up.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.up.projeto.domain.Boleto;

public interface BoletoRepository extends CrudRepository<Boleto, Long> {
    
}
