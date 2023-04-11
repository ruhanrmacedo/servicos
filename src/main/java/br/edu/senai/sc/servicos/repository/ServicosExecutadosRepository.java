package br.edu.senai.sc.servicos.repository;

import br.edu.senai.sc.servicos.entity.ServicosExecutados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosExecutadosRepository extends JpaRepository<ServicosExecutados, Long> {
}
