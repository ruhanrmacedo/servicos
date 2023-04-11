package br.edu.senai.sc.servicos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicosExecutadosDTO {
    private String nomeTecnico;
    private int qtdServicosExecutados;
    private double valorTotalClaro;
    private double valorTotalTecnico;

    public ServicosExecutadosDTO(String nomeTecnico, int qtdServicosExecutados, double valorTotalClaro, double valorTotalTecnico) {
        this.nomeTecnico = nomeTecnico;
        this.qtdServicosExecutados = qtdServicosExecutados;
        this.valorTotalClaro = valorTotalClaro;
        this.valorTotalTecnico = valorTotalTecnico;
    }
}
