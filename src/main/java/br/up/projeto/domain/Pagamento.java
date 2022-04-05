package br.up.projeto.domain;

import java.sql.Date;
import java.time.temporal.ValueRange;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue
    private Long id;
    private String pagamento;
    private Double valor;
    /* private Date data_pagamento; */

    public Pagamento() {

    }

    public Pagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Pagamento(String pagamento, Double valor) {
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public Pagamento(Long id, String pagamento, Double valor/* Date data_pagamento */) {
        this.id = id;
        this.pagamento = pagamento;
        this.valor = valor;
        /* this.data_pagamento = data_pagamento; */
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    /*--------------*/

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    /*--------------*/

    /*
     * public Date getData_pagamento() {
     * return data_pagamento;
     * }
     * 
     * public void setData_pagamento(Date data_pagamento) {
     * this.data_pagamento = data_pagamento;
     * }
     */
}
