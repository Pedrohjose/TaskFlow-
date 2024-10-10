package br.senai.taskflow.modelo.dao.Tarefa;

import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;
import java.util.List;

public interface TarefaDAO {
    void cadastrarTarefa(Tarefa tarefa);
    void alterarTarefa(Tarefa tarefa);
    void deletarTarefa(Tarefa tarefa);
    Tarefa consultarTarefa(Long id);
    List<Tarefa> listarTarefas();
}
