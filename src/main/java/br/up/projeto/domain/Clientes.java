package br.up.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Clientes {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private String datanasc;
    private String email;
    private String senha;

    // Constructor
    public Clientes() {
    }

    public Clientes(String nome) {
        this.nome = nome;
    }

    public Clientes(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Clientes(String email, String cpf, String senha) {
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Clientes(Long id, String nome, String cpf, String datanasc, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.email = email;
        this.senha = senha;
    }

    // GET
    public String getNome() {
        return this.nome;
    }

    public Long getId() {
        return this.id;
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getDatanasc() {
        return this.datanasc;
    }

    // SET
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

}
