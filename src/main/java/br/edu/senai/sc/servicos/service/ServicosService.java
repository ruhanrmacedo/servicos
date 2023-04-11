package br.edu.senai.sc.servicos.service;

import br.edu.senai.sc.servicos.entity.Servicos;
import br.edu.senai.sc.servicos.repository.ServicosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public Servicos buscarPorId(Long id) {
        return servicosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Codigo inválido:" + id));
    }

    public List<Servicos> buscarTodos() {
        return servicosRepository.findAll();
    }

    public void excluir(Long id) {
        servicosRepository.deleteById(id);
    }
}
