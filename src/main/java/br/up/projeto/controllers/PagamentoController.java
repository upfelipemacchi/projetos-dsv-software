package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.Pagamento;
import br.up.projeto.repository.PagamentoRepository;

@RestController
public class PagamentoController {

    private final PagamentoRepository repository;

    PagamentoController(PagamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pagamento")
    Iterable<Pagamento> listar() {
        return repository.findAll();
    }

    @GetMapping("/pagamento/{id}")
    Pagamento buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/pagamentoincluir")
    Pagamento incluir(@RequestBody Pagamento novoPagamento) {
        return repository.save(novoPagamento);
    }

    @PutMapping("/pagamento/{id}")
    Pagamento atualizar(@RequestBody Pagamento pagamentoAlterado, @PathVariable Long id) {
        return repository.findById(id)
                .map(pagamento -> {
                    pagamento.setPagamento(pagamentoAlterado.getPagamento());
                    return repository.save(pagamento);
                })
                .orElseGet(() -> {
                    pagamentoAlterado.setId(id);
                    return repository.save(pagamentoAlterado);
                });
    }

    @DeleteMapping("/pagamento/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
