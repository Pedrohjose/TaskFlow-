package br.senai.taskflow.modelo.entidade.tarefa;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_tarefa")
public class TipoTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "tipoTarefa", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    // Construtor padrão
    public TipoTarefa() {
    }

    // Construtor com parâmetros
    public TipoTarefa(String descricao) {
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    // Método toString
    @Override
    public String toString() {
        return "TipoTarefa{id=" + id + ", descricao='" + descricao + "'}";
    }
}
