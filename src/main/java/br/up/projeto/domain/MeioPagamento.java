package br.up.projeto.domain;

import java.sql.Date;
import java.time.temporal.ValueRange;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MeioPagamento {

    @Id
    @GeneratedValue
    private Long id;
    private String pagamento;
    private String codigo;
    private Double valor;
    /* private Date data_pagamento; */

    public MeioPagamento() {

    }

    public MeioPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public MeioPagamento(String pagamento, String codigo, Double valor) {
        this.pagamento = pagamento;
        this.codigo = codigo;
        this.valor = valor;
    }

    public MeioPagamento(Long id, String pagamento, String codigo, Double valor/* Date data_pagamento */) {
        this.id = id;
        this.pagamento = pagamento;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
