package br.senai.taskflow.modelo.entidade.tarefa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senai.taskflow.modelo.dao.Desenvolvedor.DesenvolvedorDAOImpl;
import br.senai.taskflow.modelo.dao.Tarefa.TarefaDAOImpl;
import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.taskflow.modelo.entidade.usuario.Usuario;
import br.senai.taskflow.modelo.enumeracao.StatusTarefa.StatusTarefa;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "desenvolvedor_id", nullable = false)
    private Desenvolvedor desenvolvedor;

    @ManyToOne
    @JoinColumn(name = "tipo_tarefa_id", nullable = false)
    private TipoTarefa tipoTarefa;

    @Column(nullable = false)
    private LocalDate dataCriacao;

    @Column(nullable = false)
    private LocalDate prazo;

    // Construtor padrão
    public Tarefa() {
    }

    // Construtor com todos os parâmetros
    public Tarefa(String titulo, String descricao, StatusTarefa status, Usuario usuario, Desenvolvedor desenvolvedor,
                  TipoTarefa tipoTarefa, LocalDate dataCriacao, LocalDate prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.usuario = usuario;
        this.desenvolvedor = desenvolvedor;
        this.tipoTarefa = tipoTarefa;
        this.dataCriacao = dataCriacao;
        this.prazo = prazo;
        setDesenvolvedor(desenvolvedor); 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }
    
    public TipoTarefa getTipoTarefa() {
        return tipoTarefa;
    }

    public void setTipoTarefa(TipoTarefa tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
    
}
