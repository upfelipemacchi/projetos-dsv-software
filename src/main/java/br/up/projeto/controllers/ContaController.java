package br.edu.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.projeto.domain.Conta;
import br.edu.up.projeto.repository.ContaRepository;

@RestController
public class ContaController {
    
    private final ContaRepository repository;

    ContaController(ContaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/moedas")
    Iterable<Conta> listar(){
        return repository.findAll();
    }

    @GetMapping("/moedas/{id}")
    Conta buscarPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/moedas")
    Conta incluir(@RequestBody Conta novaMoeda){
        return repository.save(novaMoeda);
    }


    @PutMapping("/moedas/{id}")
    Conta atualizar(@RequestBody Conta moedaAlterada, @PathVariable Long id){
        return repository.findById(id)
        .map(moeda -> {
            moeda.setNome(moedaAlterada.getNome());
            return repository.save(moeda);
        })
        .orElseGet(() -> {
            moedaAlterada.setId(id);
            return repository.save(moedaAlterada);
        });    
    }

    @DeleteMapping("/moedas/{id}")
    void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
