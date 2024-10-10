package br.com.fiap.faculdadeapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiplomadoResponse {
    private Long id;
    private String nome;
    private String nacionalidade;
    private String naturalidade;
    private String rg;
}
