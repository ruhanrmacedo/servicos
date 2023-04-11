package br.edu.senai.sc.servicos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TecnicoDTO {

    private Long codigoTecnico;
    private String nome;
    private String cpf;
    private LocalDateTime dataAdmissao;
    private Integer quantidadeServicosExecutados;
    private Double valorTotalClaro;
    private Double valorTotalTecnico;
}
