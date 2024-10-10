package br.com.fiap.faculdadeapi.repository;

import br.com.fiap.faculdadeapi.model.Diploma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomaRepository extends JpaRepository<Diploma, Long> {
}
