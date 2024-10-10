package br.senai.taskflow.modelo.dao.Usuario;

import br.senai.taskflow.modelo.entidade.usuario.Usuario;
import br.senai.taskflow.modelo.factory.ConexaoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void inativarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            usuario.setAtivo(false);  // supondo que o usuário tenha um campo "ativo"
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Usuario consultarUsuario(Long id) {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        try (Session session = ConexaoFactory.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
            Root<Usuario> root = criteriaQuery.from(Usuario.class);
            criteriaQuery.select(root);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
