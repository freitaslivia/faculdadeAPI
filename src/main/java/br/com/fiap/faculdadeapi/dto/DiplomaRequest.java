package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DiplomaRequest {

    @NotNull(message = "O sexo é obrigatório.")
    private Sexo sexo;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 5, message = "O nome deve conter no minimo 5 caracteres.")
    private String nome;

    @Pattern(
            regexp = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(\\d{4})$",
            message = "A data deve estar no formato dd/MM/yyyy e ser válida."
    )
    private String dataConclusao;

    @NotNull(message = "ID do diplomado é obrigatório.")
    private Long diplomado;
    @NotNull(message = "ID do curso é obrigatório.")
    private Long curso;

}
