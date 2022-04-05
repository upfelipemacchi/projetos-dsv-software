package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.ClientesRepository;
import br.up.projeto.domain.Clientes;

@RestController
public class ClientesController {

    private final ClientesRepository repository;

    ClientesController(ClientesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clientes")
    Iterable<Clientes> lsitar() {
        return repository.findAll();
    }

    @GetMapping("clientes/{id}")
    Clientes buscarPorId(@PathVariable long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/clientes")
    Clientes incluir(@RequestBody Clientes novaClientes) {
        return repository.save(novaClientes);
    }

    @PutMapping("/clientes/{id}")
    Clientes atualizar(@RequestBody Clientes clientesAlterada, @PathVariable Long id) {
        return repository.findById(id).map(clientes -> {
            clientes.setNome(clientesAlterada.getNome());
            return repository.save(clientes);
        })
                .orElseGet(() -> {
                    clientesAlterada.setId(id);
                    return repository.save(clientesAlterada);
                });
    }

    @DeleteMapping("/clientes/{id}")
    void excluir(@PathVariable long id) {
        repository.deleteById(id);
    }
}
