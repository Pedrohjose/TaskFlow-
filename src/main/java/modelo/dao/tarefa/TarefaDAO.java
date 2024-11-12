package modelo.dao.tarefa;

import java.util.List;

import modelo.entidade.tarefa.Tarefa;

public interface TarefaDAO {

	void inserirTarefa(Tarefa tarefa);

	void deletarTarefa(Tarefa tarefa);

	void atualizarTarefa(Tarefa tarefa);

	List<Tarefa> recuperarTarefas();

}