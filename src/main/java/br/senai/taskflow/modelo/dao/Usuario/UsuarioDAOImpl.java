package br.senai.taskflow.modelo.dao.Usuario;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import br.senai.taskflow.modelo.entidade.usuario.Usuario;
import br.senai.taskflow.modelo.factory.ConexaoFactory;

public class UsuarioDAOImpl implements UsuarioDAO {

    private ConexaoFactory fabrica;

    public UsuarioDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.save(usuario);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e possivelmente realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.update(usuario);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e possivelmente realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public void inativarUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            usuario.setAtivo(false);  // Inativar o usuário
            sessao.update(usuario);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e possivelmente realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }
    
    @Override
    public void deletarUsuario(Usuario usuario) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            sessao.delete(usuario);
            sessao.getTransaction().commit();  // Comitar a transação se tudo der certo
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro e possivelmente realizar rollback
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public Usuario consultarUsuario(Long id) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            return sessao.get(Usuario.class, id);  // Consultar o usuário por ID
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro
            return null;
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            CriteriaBuilder criteriaBuilder = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
            Root<Usuario> root = criteriaQuery.from(Usuario.class);
            criteriaQuery.select(root);
            return sessao.createQuery(criteriaQuery).getResultList();  // Listar todos os usuários
        } catch (Exception exception) {
            erroSessao(sessao, exception);  // Tratar erro
            return null;
        } finally {
            fecharSessao(sessao);  // Garantir que a sessão será fechada
        }
    }

    // Método auxiliar para tratar rollback e exceções
    private void erroSessao(Session sessao, Exception exception) {
        exception.printStackTrace();
        if (sessao != null && sessao.getTransaction() != null && sessao.getTransaction().isActive()) {
            sessao.getTransaction().rollback();  // Fazer rollback se a transação estiver ativa
        }
    }

    // Método auxiliar para fechar a sessão
    private void fecharSessao(Session sessao) {
        if (sessao != null) {
            sessao.close();  // Fechar a sessão
        }
    }
}
