package br.com.fiap.faculdadeapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextoDTO {
    private String nomeDiplomado;
    private String nacionalidade;
    private String naturalidade;
    private String rg;
    private String tipoCurso;
    private String nomeCurso;
    private String dataConclusao;
    private String tituloReitor;
    private String cargoReitor;
}
