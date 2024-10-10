package br.com.fiap.faculdadeapi.model;

import lombok.Getter;

@Getter
public enum Sexo {
    M("Masculino"),
    F("Feminino");


    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }
}
