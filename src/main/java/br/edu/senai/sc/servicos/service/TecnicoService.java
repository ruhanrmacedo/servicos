package br.edu.senai.sc.servicos.service;

import br.edu.senai.sc.servicos.entity.ServicosExecutados;
import br.edu.senai.sc.servicos.entity.Tecnico;
import br.edu.senai.sc.servicos.repository.TecnicoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TecnicoService {

    private TecnicoRepository tecnicoRepository;
    public int contarServicosPorTecnico(Long codigoTecnico) {
        Tecnico tecnico = (Tecnico) tecnicoRepository.findByCodigoTecnico(codigoTecnico);
        List<ServicosExecutados> servicosExecutados = tecnico.getServicosExecutados();
        int contadorServicos = 0;

        for (ServicosExecutados servicoExecutado : servicosExecutados) {
            contadorServicos += servicoExecutado.getServicoExecutadoItems().size();
        }

        return contadorServicos;
    }
}
