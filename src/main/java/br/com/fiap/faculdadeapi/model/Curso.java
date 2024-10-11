package br.com.fiap.faculdadeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="tb_curso")
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoCurso tipo;

    @OneToMany(mappedBy = "curso")
    private List<Diploma> diploma;

}
