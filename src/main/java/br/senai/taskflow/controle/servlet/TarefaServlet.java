package br.senai.taskflow.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.taskflow.modelo.dao.Tarefa.TarefaDAOImpl;
import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;
import br.senai.taskflow.modelo.enumeracao.StatusTarefa.StatusTarefa;

@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {

    
	private static final long serialVersionUID = -2497350999579461403L;
	private TarefaDAOImpl tarefaDAO;

    public void init() {
        tarefaDAO = new TarefaDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "cadastrar":
                    cadastrarTarefa(request, response);
                    break;
                case "editar":
                    editarTarefa(request, response);
                    break;
                case "deletar":
                    deletarTarefa(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cadastrarTarefa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        LocalDate dataCriacao = LocalDate.now();
        LocalDate prazo = LocalDate.parse(request.getParameter("prazo"));

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setDataCriacao(dataCriacao);
        tarefa.setPrazo(prazo);
        tarefa.setStatus(StatusTarefa.EM_ANDAMENTO);

        tarefaDAO.cadastrarTarefa(tarefa);

        response.sendRedirect("tarefas");  // Redireciona após cadastro
    }

    private void editarTarefa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        LocalDate prazo = LocalDate.parse(request.getParameter("prazo"));

        Tarefa tarefa = new Tarefa();
        tarefa.setId(id);
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setPrazo(prazo);

        tarefaDAO.alterarTarefa(tarefa);

        response.sendRedirect("tarefas");
    }

    private void deletarTarefa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        tarefaDAO.deletarTarefa(id);

        response.sendRedirect("tarefas");
    }
}
