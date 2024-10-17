package br.senai.taskflow.modelo.entidade.desenvolvedor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;

@Entity
@Table(name = "desenvolvedores")
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String matricula;

    @OneToMany(mappedBy = "desenvolvedor", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas;

    // Construtor padrão
    public Desenvolvedor() {
        this.tarefas = new ArrayList<>(); // Inicializa a lista no construtor padrão
    }

    // Construtor com todos os parâmetros
    public Desenvolvedor(String nome, String email, String matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.tarefas = new ArrayList<>(); // Inicializa a lista
    }


    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    public void adicionarTarefa(Tarefa tarefa) {
        tarefa.setDesenvolvedor(this); 
        this.tarefas.add(tarefa);    
        }

}
