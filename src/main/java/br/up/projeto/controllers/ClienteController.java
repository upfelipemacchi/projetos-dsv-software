package br.up.projeto.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.up.projeto.domain.Cliente;
import br.up.projeto.repository.ClienteRepository;

@RestController
public class ClienteController {

    private final ClienteRepository repository;

    ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clientes")
    Iterable<Cliente> lsitar() {
        return repository.findAll();
    }

    @GetMapping("clientes/{id}")
    Cliente buscarPorId(@PathVariable long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/clientes")
    Cliente incluir(@RequestBody Cliente novaClientes) {
        return repository.save(novaClientes);
    }

    @PutMapping("/clientes/{id}")
    Cliente atualizar(@RequestBody Cliente clientesAlterada, @PathVariable Long id) {
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
