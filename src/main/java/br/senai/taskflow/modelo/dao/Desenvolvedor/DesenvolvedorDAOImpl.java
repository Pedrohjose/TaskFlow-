package br.senai.taskflow.modelo.dao.Desenvolvedor;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.taskflow.modelo.factory.ConexaoFactory;

public class DesenvolvedorDAOImpl implements DesenvolvedorDAO {

    private ConexaoFactory fabrica;

    public DesenvolvedorDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    @Override
    public void cadastrarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(desenvolvedor);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void alterarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(desenvolvedor);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void deletarDesenvolvedor(Long id) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            Desenvolvedor desenvolvedor = sessao.get(Desenvolvedor.class, id);
            if (desenvolvedor != null) {
                sessao.beginTransaction();
                sessao.delete(desenvolvedor);
                sessao.getTransaction().commit();
            }
        } catch (Exception exception) {
            erroSessao(sessao, exception);
        } finally {
            fecharSessao(sessao);
        }
    }


    @Override
    public Desenvolvedor consultarDesenvolvedor(Long id) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            return sessao.get(Desenvolvedor.class, id);  // Retornar a entidade consultada
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }
    public Desenvolvedor buscarPorEmail(String email) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();  // Abrir a sessão
            return (Desenvolvedor) sessao.createQuery("FROM Desenvolvedor WHERE email = :email")
                    .setParameter("email", email)
                    .uniqueResult();  // Retornar o desenvolvedor encontrado
        } catch (Exception exception) {
            exception.printStackTrace();  // Tratar exceção
            return null;
        } finally {
            fecharSessao(sessao);  // Fechar a sessão
        }
    }


    @Override
    public List<Desenvolvedor> listarDesenvolvedores() {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
            CriteriaQuery<Desenvolvedor> criteriaQuery = criteriaBuilder.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> root = criteriaQuery.from(Desenvolvedor.class);
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
