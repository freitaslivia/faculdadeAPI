package br.com.fiap.faculdadeapi.repository;

import br.com.fiap.faculdadeapi.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <Curso, Long> {
}
