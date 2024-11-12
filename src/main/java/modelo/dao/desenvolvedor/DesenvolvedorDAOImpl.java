package modelo.dao.desenvolvedor;

import modelo.entidade.factory.ConexaoFactory;
import modelo.entidade.desenvolvedor.Desenvolvedor;

import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

public class DesenvolvedorDAOImpl implements DesenvolvedorDAO {

	private final ConexaoFactory fabrica;

	public DesenvolvedorDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	private void erroSessao(Session sessao, Exception exception) {
		exception.printStackTrace();
		if (sessao.getTransaction() != null) {
			sessao.getTransaction().rollback();
		}
	}

	private void fecharSessao(Session sessao) {
		if (sessao != null) {
			sessao.close();
		}
	}

	private Session abrirSessao(Session sessao) {
		sessao = fabrica.getConexao().openSession();
		sessao.beginTransaction();
		return sessao;
	}

	public void inserirDesenvolvedor(Desenvolvedor desenvolvedor) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(desenvolvedor);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarDesenvolvedor(Desenvolvedor desenvolvedor) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(desenvolvedor);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarDesenvolvedor(Desenvolvedor desenvolvedor) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(desenvolvedor);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<Desenvolvedor> recuperarDesenvolvedores() {
		Session sessao = null;
		List<Desenvolvedor> desenvolvedores = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Desenvolvedor> criteria = construtor.createQuery(Desenvolvedor.class);
			Root<Desenvolvedor> raizCliente = criteria.from(Desenvolvedor.class);
			criteria.select(raizCliente);
			desenvolvedores = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return desenvolvedores;
	}
}
