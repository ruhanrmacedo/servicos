package br.edu.senai.sc.servicos.controller;

import br.edu.senai.sc.servicos.entity.Tecnico;
import br.edu.senai.sc.servicos.service.TecnicoService;
import br.edu.senai.sc.servicos.repository.TecnicoRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tecnicos")
@Slf4j
public class TecnicoController {
    private final TecnicoService tecnicoService;


    public TecnicoController(TecnicoService tecnicoService, TecnicoRepository tecnicoRepository) {
        this.tecnicoService = tecnicoService;
    }

    @PostMapping
    @ApiOperation(value = "Criação de Técnico")
    public ResponseEntity<String> criarRegistro(@RequestBody Tecnico tecnico) {
        try {
            tecnicoService.salvar(tecnico);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao criar Técnico", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Técnico criado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualização de Técnico")
    public ResponseEntity<String> atualizarRegistro(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoOptional = Optional.ofNullable((Tecnico) tecnicoService.buscarPorId(id));
        if (!tecnicoOptional.isPresent()) {
            return new ResponseEntity<>("Técnico não encontrado", HttpStatus.NOT_FOUND);
        }
        tecnico.setId(id);
        try {
            tecnicoService.salvar(tecnico);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar Técnico", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Técnico atualizado com sucesso", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "Atualização de apenas alguns dados de Técnico")
    public ResponseEntity<String> atualizarDadosRegistro(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        Optional<Tecnico> tecnicoOptional = Optional.ofNullable((Tecnico) tecnicoService.buscarPorId(id));
        if (!tecnicoOptional.isPresent()) {
            return new ResponseEntity<>("Registro não encontrado", HttpStatus.NOT_FOUND);
        }
        tecnico.setId(id);
        try {
            tecnicoService.salvar(tecnico);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao atualizar registro", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Dados do registro atualizados com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclusão de Registro")
    public ResponseEntity<String> excluirRegistro(@PathVariable Long id) {
        Optional<Tecnico> tecnicoOptional = Optional.ofNullable((Tecnico) tecnicoService.buscarPorId(id));
        if (!tecnicoOptional.isPresent()) {
            return new ResponseEntity<>("Registro não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            tecnicoService.excluir(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Erro ao excluir registro", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Registro excluído com sucesso", HttpStatus.OK);


    }
}