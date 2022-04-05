package br.up.projeto;

import org.springframework.data.repository.CrudRepository;

import br.up.projeto.domain.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {

}
