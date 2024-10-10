package br.com.fiap.faculdadeapi.repository;

import br.com.fiap.faculdadeapi.model.Diplomado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomadoRepository extends JpaRepository<Diplomado, Long> {
}
