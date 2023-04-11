package br.edu.senai.sc.servicos.repository;

import br.edu.senai.sc.servicos.entity.Servicos;
import br.edu.senai.sc.servicos.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Object findByCodigoTecnico(Long codigoTecnico);
    List<Servicos> findByDescricaoContainingIgnoreCase(String nome);
}
