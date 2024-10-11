package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiplomaResponse {
    private String id;
    private Sexo sexo;
    private String nome;
}
