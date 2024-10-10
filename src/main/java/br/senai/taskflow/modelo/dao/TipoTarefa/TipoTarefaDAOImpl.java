package br.senai.taskflow.modelo.dao.TipoTarefa;

import br.senai.taskflow.modelo.entidade.tarefa.TipoTarefa;
import br.senai.taskflow.modelo.factory.ConexaoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TipoTarefaDAOImpl implements TipoTarefaDAO {

    @Override
    public void cadastrarTipoTarefa(TipoTarefa tipoTarefa) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tipoTarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void alterarTipoTarefa(TipoTarefa tipoTarefa) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tipoTarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deletarTipoTarefa(TipoTarefa tipoTarefa) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tipoTarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public TipoTarefa consultarTipoTarefa(Long id) {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            return session.get(TipoTarefa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TipoTarefa> listarTiposTarefa() {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TipoTarefa> criteriaQuery = criteriaBuilder.createQuery(TipoTarefa.class);
            Root<TipoTarefa> root = criteriaQuery.from(TipoTarefa.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
