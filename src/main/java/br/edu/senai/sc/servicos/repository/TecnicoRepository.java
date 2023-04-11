package br.edu.senai.sc.servicos.repository;

import br.edu.senai.sc.servicos.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Object findByCodigoTecnico(Long codigoTecnico);
}
