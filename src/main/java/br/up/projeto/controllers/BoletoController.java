package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.Boleto;
import br.up.projeto.repository.BoletoRepository;
@RestController
public class BoletoController {

    private final BoletoRepository repository;

    BoletoController(BoletoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/boleto")
    Iterable<Boleto> listar() {
        return repository.findAll();
    }

    @GetMapping("/boleto/{id}")
    Boleto buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/boleto")
    Boleto incluir(@RequestBody Boleto novaBoleto) {
        return repository.save(novaBoleto);
    }

    @PutMapping("/boleto/{id}")
    Boleto atualizar(@RequestBody Boleto boletoAlterada, @PathVariable Long id) {
        return repository.findById(id)
                .map(boleto -> {
                    boleto.setCodigoDeBarras(boletoAlterada.getCodigoDeBarras());
                    return repository.save(boleto);
                })
                .orElseGet(() -> {
                    boletoAlterada.setId(id);
                    return repository.save(boletoAlterada);
                });
    }

    @DeleteMapping("/boleto/{id}")
    void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
