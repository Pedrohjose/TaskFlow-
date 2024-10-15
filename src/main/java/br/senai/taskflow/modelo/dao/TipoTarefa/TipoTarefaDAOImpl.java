package br.senai.taskflow.modelo.dao.TipoTarefa;

import br.senai.taskflow.modelo.entidade.tarefa.TipoTarefa;
import br.senai.taskflow.modelo.factory.ConexaoFactory;
import org.hibernate.Session;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TipoTarefaDAOImpl implements TipoTarefaDAO {

    private ConexaoFactory fabrica;

    public TipoTarefaDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    @Override
    public void cadastrarTipoTarefa(TipoTarefa tipoTarefa) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(tipoTarefa);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void alterarTipoTarefa(TipoTarefa tipoTarefa) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(tipoTarefa);
            sessao.getTransaction().commit();  // Comitar a transação
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void deletarTipoTarefa(TipoTarefa tipoTarefa) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(tipoTarefa);
            sessao.getTransaction().commit();  // Comitar a transação
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public TipoTarefa consultarTipoTarefa(Long id) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            return sessao.get(TipoTarefa.class, id);  // Retornar a entidade consultada
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public List<TipoTarefa> listarTiposTarefa() {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
            CriteriaQuery<TipoTarefa> criteriaQuery = criteriaBuilder.createQuery(TipoTarefa.class);
            Root<TipoTarefa> root = criteriaQuery.from(TipoTarefa.class);
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
