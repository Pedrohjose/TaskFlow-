package br.senai.taskflow.modelo.dao.TipoTarefa;

import br.senai.taskflow.modelo.entidade.tarefa.TipoTarefa;
import java.util.List;

public interface TipoTarefaDAO {
    void cadastrarTipoTarefa(TipoTarefa tipoTarefa);
    void alterarTipoTarefa(TipoTarefa tipoTarefa);
    void deletarTipoTarefa(TipoTarefa tipoTarefa);
    TipoTarefa consultarTipoTarefa(Long id);
    List<TipoTarefa> listarTiposTarefa();
}
