package modelo.entidade.tarefa;
 
import java.io.ObjectInputFilter.Status;
//Tarefa (idTarefa*, nome, descrição, status, dt_criação, dt_prazo, dt_completação)
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import modelo.entidade.desenvolvedor.Desenvolvedor;

@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarefa")
	private long idTarefa;
	
	@Column(name = "nome_tarefa", length = 45, nullable = false)
	private String nomeTarefa;
	
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private modelo.enumeracao.status.Status status;
	
	public modelo.enumeracao.status.Status getStatus() {
		return status;
	}

	public void setStatus(modelo.enumeracao.status.Status status) {
		this.status = status;
	}

	@Column(name = "dt_criacao", nullable = false)
	private LocalDate dataCriacao;
	
	@Column(name = "dt_prazo", nullable = false)
	private LocalDate dataPrazo;
	
	@Column(name = "dt_conclusao", nullable = true)
	private LocalDate dataConclusao;
	
	@ManyToMany(mappedBy = "tarefas", fetch = FetchType.LAZY)
    private Set<Desenvolvedor> desenvolvedores = new HashSet<>();

	
	
	public long getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(long idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(LocalDate dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Set<Desenvolvedor> getDesenvolvedores() {
		return desenvolvedores;
	}

	public void setDesenvolvedores(Set<Desenvolvedor> desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
