package br.senai.taskflow.modelo.dao.Desenvolvedor;

import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.taskflow.modelo.factory.ConexaoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DesenvolvedorDAOImpl implements DesenvolvedorDAO {

    @Override
    public void cadastrarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(desenvolvedor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void alterarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(desenvolvedor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deletarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(desenvolvedor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Desenvolvedor consultarDesenvolvedor(Long id) {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            return session.get(Desenvolvedor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Desenvolvedor> listarDesenvolvedores() {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Desenvolvedor> criteriaQuery = criteriaBuilder.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> root = criteriaQuery.from(Desenvolvedor.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
