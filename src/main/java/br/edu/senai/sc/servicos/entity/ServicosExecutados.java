package br.edu.senai.sc.servicos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ServicosExecutados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    private LocalDateTime dataExecucao;

    @OneToMany(mappedBy = "servicoExecutado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServicoExecutadoItem> servicoExecutadoItems;

    public List<ServicoExecutadoItem> getServicoExecutadoItems() {
        return this.servicoExecutadoItems;
    }
}
