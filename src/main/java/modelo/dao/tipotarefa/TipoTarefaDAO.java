package modelo.dao.tipotarefa;

import java.util.List;

import modelo.entidade.tipotarefa.TipoTarefa;

public interface TipoTarefaDAO {
	void inserirTipoTarefa(TipoTarefa tipoTarefa);

	void deletarTipoTarefa(TipoTarefa tipoTarefa);

	void atualizarTipoTarefa(TipoTarefa tipoTarefa);
	
	TipoTarefa recuperarTipoTarefaPorIdUsaurio(Long id);

	List<TipoTarefa> recuperarTipoTarefas();
	
}
