package br.edu.senai.sc.servicos.controller;

import br.edu.senai.sc.servicos.entity.Servicos;
import br.edu.senai.sc.servicos.service.ServicosService;
import br.edu.senai.sc.servicos.repository.ServicosRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
@Slf4j
public class ServicosController {

    private final ServicosService servicosService;
    private final ServicosRepository servicosRepository;

    public ServicosController(ServicosService servicosService, ServicosRepository servicosRepository) {
        this.servicosService = servicosService;
        this.servicosRepository = servicosRepository;
    }

    @PostMapping
    @ApiOperation(value = "Criação de Serviço")
    public ResponseEntity<String> criarRegistro(@RequestBody Servicos servico) {
        try {
            servicosService.salvar(servico);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao criar Serviço", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Serviço criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualização de Serviço")
    public ResponseEntity<String> atualizarRegistro(@PathVariable Long id, @RequestBody Servicos servico) {
        Optional<Servicos> servicoOptional = Optional.ofNullable(servicosService.buscarPorId(id));
        if (!servicoOptional.isPresent()) {
            return new ResponseEntity<>("Serviço não encontrado", HttpStatus.NOT_FOUND);
        }
        servico.setId(id);
        try {
            servicosService.salvar(servico);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar Serviço", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Serviço atualizado com sucesso", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "Atualização de apenas alguns dados de Serviço")
    public ResponseEntity<String> atualizarDadosRegistro(@PathVariable Long id, @RequestBody Servicos servico) {
        Optional<Servicos> servicoOptional = Optional.ofNullable(servicosService.buscarPorId(id));
        if (!servicoOptional.isPresent()) {
            return new ResponseEntity<>("Registro não encontrado", HttpStatus.NOT_FOUND);
        }
        servico.setId(id);
        try {
            servicosService.salvar(servico);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar Serviço", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Dados do Serviço atualizados com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclusão de Serviço")
    public ResponseEntity<String> excluirRegistro(@PathVariable Long id) {
        Optional<Servicos> servicoOptional = Optional.ofNullable(servicosService.buscarPorId(id));
        if (!servicoOptional.isPresent()) {
            return new ResponseEntity<>("Registro não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            servicosService.excluir(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao excluir Serviço", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Serviço excluído com sucesso", HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Busca de todos os Serviço de determinada tabela")
    public ResponseEntity<List<Servicos>> buscarTodosRegistros() {
        List<Servicos> servicos = servicosService.buscarTodos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @GetMapping(params = "filtro")
    @ApiOperation(value = "Buscar Serviços filtrados por algum campo")
    public ResponseEntity<List<Servicos>> buscarServicosPorFiltro(@RequestParam("filtro") String filtro){
        try{
            List<Servicos> servicos = servicosRepository.findByDescricaoContainingIgnoreCase(filtro);
            return new ResponseEntity<>(servicos, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{codigo}")
    @ApiOperation(value = "Buscar Serviço filtrado por código")
    public ResponseEntity<Servicos> buscarServicosPorCodigo(@PathVariable("codigo") Long codigo){
        try{
            Optional<Servicos> servico = servicosRepository.findById(codigo);
            if(servico.isPresent())
                return new ResponseEntity<>(servico.get(), HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
