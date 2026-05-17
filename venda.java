package com.dash.raquel.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

//identifica q uma classe é um entidade
@Getter
@Entity
public class venda {

    //representa q o campo é uma chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mes;
    private double valor;

    public venda() {
    }
    public venda(Long id, String mes, double valor) {
        this.id = id;
        this.mes = mes;
        this.valor = valor;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
