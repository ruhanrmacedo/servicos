package br.edu.senai.sc.servicos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ServicoExecutadoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servicos servico;

    @ManyToOne
    @JoinColumn(name = "servico_executado_id")
    private ServicosExecutados servicoExecutado;

    private int quantidade;

    private Double valorClaro;

    private Double valorTecnico;


}
