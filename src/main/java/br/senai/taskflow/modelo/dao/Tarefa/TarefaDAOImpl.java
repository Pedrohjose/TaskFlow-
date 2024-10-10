package br.senai.taskflow.modelo.dao.Tarefa;

import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;
import br.senai.taskflow.modelo.factory.ConexaoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TarefaDAOImpl implements TarefaDAO {

    @Override
    public void cadastrarTarefa(Tarefa tarefa) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void alterarTarefa(Tarefa tarefa) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(tarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deletarTarefa(Tarefa tarefa) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tarefa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Tarefa consultarTarefa(Long id) {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            return session.get(Tarefa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tarefa> listarTarefas() {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Tarefa> criteriaQuery = criteriaBuilder.createQuery(Tarefa.class);
            Root<Tarefa> root = criteriaQuery.from(Tarefa.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
