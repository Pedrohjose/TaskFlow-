package modelo.controle.servlet.tarefa;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.tarefa.TarefaDAO;
import modelo.dao.tarefa.TarefaDAOImpl;
import modelo.entidade.tarefa.Tarefa;
import modelo.enumeracao.status.StatusTarefa;

@WebServlet(urlPatterns = {"/cadastrar-tarefa", "/inserir-tarefa", "/listar-tarefas"})
public class TarefaServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1L;
    private TarefaDAO daoTarefa;

    public void init() {
        daoTarefa = new TarefaDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/cadastrar-tarefa":
                    mostrarCadastroTarefa(request, response);
                    break;

                case "/inserir-tarefa":
                    inserirTarefa(request, response);
                    break;

                case "/listar-tarefas":
                    listarTarefas(request, response);
                    break;

                default:
                    response.sendRedirect("index.jsp");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void mostrarCadastroTarefa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/tarefa/cadastrar-tarefa.jsp");
        dispatcher.forward(request, response);
    }

    private void inserirTarefa(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa(request.getParameter("nome"));
        tarefa.setDescricao(request.getParameter("descricao"));
        tarefa.setDataCriacao(LocalDate.now());
        tarefa.setDataPrazo(LocalDate.parse(request.getParameter("dataPrazo")));
        tarefa.setStatus(StatusTarefa.valueOf(request.getParameter("status")));

        daoTarefa.inserirTarefa(tarefa);
        response.sendRedirect("listar-tarefas");
    }

    private void listarTarefas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Tarefa> listaTarefas = daoTarefa.recuperarTarefas();
        request.setAttribute("listaTarefas", listaTarefas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/tarefa/listar-tarefas.jsp");
        dispatcher.forward(request, response);
    }
}
