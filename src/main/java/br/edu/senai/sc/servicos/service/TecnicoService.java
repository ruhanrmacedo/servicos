package br.edu.senai.sc.servicos.service;

import br.edu.senai.sc.servicos.entity.ServicosExecutados;
import br.edu.senai.sc.servicos.entity.Tecnico;
import br.edu.senai.sc.servicos.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TecnicoService {

    private TecnicoRepository tecnicoRepository;
    public int contarServicosPorTecnico(Long codigoTecnico) {
        Optional<Tecnico> tecnicoOptional = (Optional<Tecnico>) tecnicoRepository.findByCodigoTecnico(codigoTecnico);
        if (!tecnicoOptional.isPresent()) {
            return 0;
        }
        Tecnico tecnico = tecnicoOptional.get();
        List<ServicosExecutados> servicosExecutados = tecnico.getServicosExecutados();
        int contadorServicos = 0;

        for (ServicosExecutados servicoExecutado : servicosExecutados) {
            contadorServicos += servicoExecutado.getServicoExecutadoItems().size();
        }

        return contadorServicos;
    }

    public void salvar(Tecnico tecnico) {
        tecnicoRepository.save(tecnico);
    }

    public Object buscarPorId(Long id) {
        Optional<Tecnico> tecnicoOptional = tecnicoRepository.findById(id);
        if (tecnicoOptional.isPresent()) {
            return tecnicoOptional.get();
        } else {
            return null;
        }
    }

    public void excluir(Long id) {
        tecnicoRepository.deleteById(id);
    }

    public List<Tecnico> buscarTodos() {
        return tecnicoRepository.findAll();
    }
}
