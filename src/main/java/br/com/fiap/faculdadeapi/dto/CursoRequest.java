package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.TipoCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoRequest {

    @NotBlank(message = "O nome do curso é obrigatório.")
    @Size(min = 2, message = "O nome do curso deve conter no mínimo 2 caracteres.")
    private String nome;

    @NotNull(message = "O tipo do curso é obrigatório.")
    private TipoCurso tipo;
}
