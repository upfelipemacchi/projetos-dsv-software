package br.up.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.up.projeto.domain.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

}
