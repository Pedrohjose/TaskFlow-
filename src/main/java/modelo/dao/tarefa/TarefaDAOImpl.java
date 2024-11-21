package modelo.dao.tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.factory.ConexaoFactory;
import modelo.entidade.tarefa.Tarefa;

public class TarefaDAOImpl implements TarefaDAO{

	private final ConexaoFactory fabrica;

	public TarefaDAOImpl() {
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

	public void inserirTarefa(Tarefa tarefa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.save(tarefa);
			sessao.getTransaction().commit();

		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void deletarTarefa(Tarefa tarefa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.delete(tarefa);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}

	public void atualizarTarefa(Tarefa tarefa) {
		Session sessao = null;
		try {
			sessao = abrirSessao(sessao);
			sessao.update(tarefa);
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
	}
	
	public Tarefa recuperarTarefaPorIdUsaurio(Long id) {
		Session sessao = null;
		Tarefa tarefa = null;
		
			try {
				sessao = abrirSessao(sessao);
				
				CriteriaBuilder contrutor = sessao.getCriteriaBuilder();
				CriteriaQuery<Tarefa> criteria = contrutor.createQuery(Tarefa.class);
				Root<Tarefa> raizDesenvolvedor = criteria.from(Tarefa.class);
				criteria.select(raizDesenvolvedor).where(contrutor.equal(raizDesenvolvedor.get("idTarefa"), id));
				
				tarefa = sessao.createQuery(criteria).getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				fecharSessao(sessao);
			}
			
			return tarefa;
			
	}

	public List<Tarefa> recuperarTarefas() {
		Session sessao = null;
		List<Tarefa> tarefas = null;
		try {
			sessao = abrirSessao(sessao);
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Tarefa> criteria = construtor.createQuery(Tarefa.class);
			Root<Tarefa> raizCliente = criteria.from(Tarefa.class);
			criteria.select(raizCliente);
			tarefas = sessao.createQuery(criteria).getResultList();
			sessao.getTransaction().commit();
		} catch (Exception exception) {
			erroSessao(sessao, exception);
		} finally {
			fecharSessao(sessao);
		}
		return tarefas;
	}

}
