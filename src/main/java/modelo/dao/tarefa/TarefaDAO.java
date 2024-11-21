package modelo.dao.tarefa;

import java.util.List;

import modelo.entidade.tarefa.Tarefa;
import modelo.entidade.tipotarefa.TipoTarefa;

public interface TarefaDAO {

	void inserirTarefa(Tarefa tarefa);

	void deletarTarefa(Tarefa tarefa);

	void atualizarTarefa(Tarefa tarefa);
	
	Tarefa recuperarTarefaPorIdUsaurio(Long id);

	List<Tarefa> recuperarTarefas();

}