package br.com.fiap.faculdadeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_diplomado")
@Getter
@Setter
public class Diploma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Diplomado diplomado;

    @OneToOne
    @JoinColumn(name = "id")
    private Curso curso;

    @Column(name = "sexo_reitor")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "nome_reitor")
    private String nome;
}
