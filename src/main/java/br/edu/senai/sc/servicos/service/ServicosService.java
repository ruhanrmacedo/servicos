package br.edu.senai.sc.servicos.service;

import br.edu.senai.sc.servicos.entity.Servicos;
import br.edu.senai.sc.servicos.repository.ServicosRepository;

import java.util.List;

public class ServicosService {
    private final ServicosRepository servicosRepository;

    public ServicosService(ServicosRepository servicosRepository) {
        this.servicosRepository = servicosRepository;
    }

    public Servicos salvar(Servicos servicos) {
        return servicosRepository.save(servicos);
    }

    public List<Servicos> listarTodos() {
        return servicosRepository.findAll();
    }
}
