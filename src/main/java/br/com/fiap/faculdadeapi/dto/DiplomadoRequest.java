package br.com.fiap.faculdadeapi.dto;

import br.com.fiap.faculdadeapi.model.Curso;
import br.com.fiap.faculdadeapi.model.Diplomado;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiplomadoRequest {

    @NotBlank(message = "O nome do diplomado é obrigatório.")
    @Size(min = 5, message = "O nome do diplomado deve conter no minimo 5 caracteres.")
    private String nome;

    @NotBlank(message = "A nacionalidade do diplomado é obrigatória.")
    private String nacionalidade;

    @NotBlank(message = "A naturalidade do diplomado é obrigatória.")
    @Pattern(regexp = "^[A-ZÁÀÃÂÉÊÍÓÔÕÚÇa-záàãâéêíóôõúç]+(?: [A-ZÁÀÃÂÉÊÍÓÔÕÚÇa-záàãâéêíóôõúç]+)* - [A-Z]{2}$",
            message = "Formato inválido. Use 'Cidade - UF', ex: 'São Paulo - SP'")
    private String naturalidade;

    @NotBlank(message = "O RG do diplomado é obrigatório.")
    @Pattern(regexp = "\\d{9}", message = "O RG deve conter 9 números.")
    private String rg;


}
