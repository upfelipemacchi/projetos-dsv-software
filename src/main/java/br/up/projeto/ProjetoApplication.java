package br.up.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProjetoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return  "<a href='localhost:8080/'>Home</a><br/>" +
                "<a href='localhost:8080/contas'>Contas</a><br/>" +
                "<a href='localhost:8080/lancamento-financeiro'>Lançamento financeiro</a><br/>" +
                "<a href='localhost:8080/meio-de-pagamento'>Meio de pagamento</a><br/>" +
                "<a href='localhost:8080/operadora'>Operadora (bandeira)</a><br/>" +
                "<a href='localhost:8080/moedas'>Índices e moedas</a><br/>" +
                "<a href='localhost:8080/cliente'>Cliente</a><br/>";
    }

}
