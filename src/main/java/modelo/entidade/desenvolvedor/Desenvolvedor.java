package modelo.entidade.desenvolvedor;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.entidade.tarefa.Tarefa;
import modelo.entidade.usuario.Usuario;
import modelo.enumeracao.funcaodesenvolvedor.FuncaoDesenvolvedor;

@Entity
@Table(name = "desenvolvedor")
public class Desenvolvedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cpf", length = 11)
	private String cpf;

	@Column(name = "nome_desenvolvedor", length = 45, nullable = false)
	private String nomeDesenvolvedor;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "desenvolvedor_tarefa",
        joinColumns = @JoinColumn(name = "id_desenvolvedor"),
        inverseJoinColumns = @JoinColumn(name = "id_tarefa")
    )
    private Set<Tarefa> tarefas =  new HashSet<>();

	@Enumerated(EnumType.STRING)
	private FuncaoDesenvolvedor funcao;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Set<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeDesenvolvedor() {
		return nomeDesenvolvedor;
	}

	public void setNomeDesenvolvedor(String nomeDesenvolvedor) {
		this.nomeDesenvolvedor = nomeDesenvolvedor;
	}

	public FuncaoDesenvolvedor getFuncao() {
		return funcao;
	}

	public void setFuncao(FuncaoDesenvolvedor funcao) {
		this.funcao = funcao;
	}

}
