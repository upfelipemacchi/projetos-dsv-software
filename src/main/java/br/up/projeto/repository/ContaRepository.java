package br.edu.up.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.projeto.domain.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {
    
}
