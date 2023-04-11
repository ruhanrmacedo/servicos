package br.edu.senai.sc.servicos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tecnico {
    @Id
    private Long codigoTecnico;
    private String nome;
    private String cpf;
    private LocalDateTime dataAdmissao;

    @OneToMany(mappedBy = "codigoTecnico")
    private List<ServicosExecutados> servicosExecutados;

    public String getNomeTecnico() {
        return this.nome;
    }

    public void setId(Long codigoTecnico) {
        this.codigoTecnico = codigoTecnico;
    }
}
