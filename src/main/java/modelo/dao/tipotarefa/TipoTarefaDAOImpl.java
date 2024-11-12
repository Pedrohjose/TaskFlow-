package modelo.dao.tipotarefa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.factory.ConexaoFactory;
import modelo.entidade.tipotarefa.TipoTarefa;

public class TipoTarefaDAOImpl implements TipoTarefaDAO{

	private final ConexaoFactory fabrica;

	public TipoTarefaDAOImpl() {
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

	public void inserirTipoTarefa(TipoTarefa tipoTarefa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(tipoTarefa);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarTipoTarefa(TipoTarefa tipoTarefa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(tipoTarefa);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarTipoTarefa(TipoTarefa tipoTarefa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(tipoTarefa);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public List<TipoTarefa> recuperarTipoTarefas() {
		Session sessao = null;
		List<TipoTarefa> tipoTarefas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<TipoTarefa> criteria = construtor.createQuery(TipoTarefa.class);
			Root<TipoTarefa> raizCliente = criteria.from(TipoTarefa.class);
			criteria.select(raizCliente);
			tipoTarefas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return tipoTarefas;
	}
}
