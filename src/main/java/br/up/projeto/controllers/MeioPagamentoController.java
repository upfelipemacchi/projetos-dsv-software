package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.MeioPagamento;
import br.up.projeto.repository.MeioPagamentoRepository;

@RestController
public class MeioPagamentoController {

    private final MeioPagamentoRepository repository;

    MeioPagamentoController(MeioPagamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/meiopagamento")
    Iterable<MeioPagamento> listar() {
        return repository.findAll();
    }

    @GetMapping("/meiopagamento/{id}")
    MeioPagamento buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/meiopagamentoincluir")
    MeioPagamento incluir(@RequestBody MeioPagamento novoPagamento) {
        return repository.save(novoPagamento);
    }

    @PutMapping("/meiopagamento/{id}")
    MeioPagamento atualizar(@RequestBody MeioPagamento pagamentoAlterado, @PathVariable Long id) {
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

    @DeleteMapping("/meiopagamento/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
