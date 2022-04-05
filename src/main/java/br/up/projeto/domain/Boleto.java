package br.up.projeto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Boleto {

    @Id
    @GeneratedValue
    private Long id;
    private String codigoDeBarras;
    private String nossoNum;

    public Boleto() {

    }

    public Boleto(Long id) {
        this.id = id;
    }

    public Boleto(String codigoDeBarras, String nossoNum) {
        this.codigoDeBarras = codigoDeBarras;
        this.nossoNum = nossoNum;
    }

    public Boleto(Long id, String codigoDeBarras, String nossoNum) {
        this.id = id;
        this.codigoDeBarras = codigoDeBarras;
        this.nossoNum = nossoNum;
    }

    // GETTERS
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public String getNossoNum() {
        return nossoNum;
    }

    public Long getId() {
        return id;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setNossoNum(String nossoNum) {
        this.nossoNum = nossoNum;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

}
