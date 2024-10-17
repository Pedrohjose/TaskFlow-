package br.senai.taskflow.modelo.dao.Tarefa;

import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;
import br.senai.taskflow.modelo.factory.ConexaoFactory;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TarefaDAOImpl implements TarefaDAO {

    private ConexaoFactory fabrica;

    public TarefaDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    @Override
    public void cadastrarTarefa(Tarefa tarefa) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(tarefa);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void alterarTarefa(Tarefa tarefa) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(tarefa);
            sessao.getTransaction().commit();  // Comitar a transação
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void deletarTarefa(Long id) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Buscar a tarefa pelo ID
            Tarefa tarefa = sessao.get(Tarefa.class, id);
            if (tarefa != null) {
                sessao.delete(tarefa);  // Deletar a tarefa se encontrada
            }

            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public Tarefa consultarTarefa(Long id) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            return sessao.get(Tarefa.class, id);  // Retornar a entidade consultada
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public List<Tarefa> listarTarefas() {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
            CriteriaQuery<Tarefa> criteriaQuery = criteriaBuilder.createQuery(Tarefa.class);
            Root<Tarefa> root = criteriaQuery.from(Tarefa.class);
            criteriaQuery.select(root);
            return sessao.createQuery(criteriaQuery).getResultList();  // Retornar a lista de resultados
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    private void erroSessao(Session sessao, Exception exception) {
        exception.printStackTrace();
        if (sessao.getTransaction() != null) {
            sessao.getTransaction().rollback();  // Realizar rollback se houver erro
        }
    }

    private void fecharSessao(Session sessao) {
        if (sessao != null) {
            sessao.close();  // Fechar a sessão se não for nula
        }
    }
}
