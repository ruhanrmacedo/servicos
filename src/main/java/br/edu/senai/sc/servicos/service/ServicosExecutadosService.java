package br.edu.senai.sc.servicos.service;

import br.edu.senai.sc.servicos.dto.ServicosExecutadosDTO;
import br.edu.senai.sc.servicos.entity.ServicoExecutadoItem;
import br.edu.senai.sc.servicos.entity.ServicosExecutados;
import br.edu.senai.sc.servicos.entity.Tecnico;
import br.edu.senai.sc.servicos.repository.ServicosExecutadosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServicosExecutadosService {
    private ServicosExecutadosRepository servicosExecutadosRepository;
    private TecnicoService tecnicoService;

    public ServicosExecutadosService(ServicosExecutadosRepository servicosExecutadosRepository, TecnicoService tecnicoService) {
        this.servicosExecutadosRepository = servicosExecutadosRepository;
        this.tecnicoService = tecnicoService;
    }

    public List<ServicosExecutadosDTO> buscarServicosExecutados() {
        List<ServicosExecutadosDTO> listaServicosExecutadosDto = new ArrayList<>();
        List<ServicosExecutados> listaServicosExecutados = servicosExecutadosRepository.findAll();

        for (ServicosExecutados servicosExecutados : listaServicosExecutados) {
            Tecnico tecnico = servicosExecutados.getTecnico();
            Long codigoTecnico = tecnico.getCodigoTecnico();

            int qtdServicosExecutados = tecnicoService.contarServicosPorTecnico(codigoTecnico);
            double valorTotalClaro = 0;
            double valorTotalTecnico = 0;

            for (ServicoExecutadoItem item : servicosExecutados.getServicoExecutadoItems()) {
                valorTotalClaro += item.getValorClaro();
                valorTotalTecnico += item.getValorTecnico();
            }

            ServicosExecutadosDTO servicosExecutadosDto = new ServicosExecutadosDTO(tecnico.getNomeTecnico(), qtdServicosExecutados, valorTotalClaro, valorTotalTecnico);
            listaServicosExecutadosDto.add(servicosExecutadosDto);
        }

        return listaServicosExecutadosDto;
    }
}
