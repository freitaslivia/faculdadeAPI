package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiplomaRequest {

    @NotNull(message = "O sexo do reitor é obrigatório.")
    private Sexo sexo;

    @NotBlank(message = "O nome do reitor é obrigatório.")
    @Size(min = 20, message = "O nome do reitor deve conter no minimo 20 caracteres.")
    private String nome;
}
