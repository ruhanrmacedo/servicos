package br.edu.senai.sc.servicos.repository;

import br.edu.senai.sc.servicos.entity.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {
     List<Servicos> findByDescricaoContainingIgnoreCase(String descricao);
}
