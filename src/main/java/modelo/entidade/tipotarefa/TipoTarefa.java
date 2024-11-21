package modelo.entidade.tipotarefa;
// Tipo Tarefa (idTarefa!, prioridade, função_tarefa, categoria)
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import modelo.entidade.tarefa.Tarefa;
import modelo.enumeracao.categoria.Categoria;

@Entity
@Table(name = "tipo_tarefa")
public class TipoTarefa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_tarefa")
	private long idTipoTarefa;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tarefa", referencedColumnName = "id_tarefa")
	private Tarefa tarefa;
	
	@Column(name = "prioridade", nullable = false)
	private int prioridade;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	
	public long getIdTipoTarefa() {
		return idTipoTarefa;
	}

	public void setIdTipoTarefa(long idTipoTarefa) {
		this.idTipoTarefa = idTipoTarefa;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
