package br.com.fiap.faculdadeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="tb_diploma")
@Getter
@Setter
public class Diploma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_diplomado")
    private Diplomado diplomado;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @Column(name = "sexo_reitor")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "nome_reitor")
    private String nome;

    @Column(name = "data_conclusao")
    private Date dataConclusao;
}
