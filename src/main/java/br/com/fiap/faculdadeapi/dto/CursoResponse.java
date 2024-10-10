package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.TipoCurso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoResponse {
    private Long id;
    private String nome;
    private TipoCurso tipo;
}
