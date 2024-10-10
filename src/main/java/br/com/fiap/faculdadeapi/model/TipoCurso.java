package br.com.fiap.faculdadeapi.model;

import lombok.Getter;

@Getter
public enum TipoCurso {
    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós-graduação");


    private String descricao;

    TipoCurso(String descricao) {
        this.descricao = descricao;
    }

}
