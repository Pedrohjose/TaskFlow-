package br.senai.taskflow.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.taskflow.modelo.dao.Desenvolvedor.DesenvolvedorDAOImpl;
import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;

@WebServlet("/desenvolvedor")
public class DesenvolvedorServlet extends HttpServlet {

	private static final long serialVersionUID = 2490072569254726395L;
	private DesenvolvedorDAOImpl desenvolvedorDAO;

    public void init() {
        desenvolvedorDAO = new DesenvolvedorDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "cadastrar":
                    cadastrarDesenvolvedor(request, response);
                    break;
                case "editar":
                    editarDesenvolvedor(request, response);
                    break;
                case "deletar":
                    deletarDesenvolvedor(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cadastrarDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String matricula = request.getParameter("matricula");

        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, email, matricula);
        desenvolvedorDAO.cadastrarDesenvolvedor(desenvolvedor);

        response.sendRedirect("desenvolvedores");  // Redireciona após cadastro
    }

    private void editarDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String matricula = request.getParameter("matricula");

        Desenvolvedor desenvolvedor = new Desenvolvedor(nome, email, matricula);
        desenvolvedor.setId(id);  // Define o ID para atualizar
        desenvolvedorDAO.alterarDesenvolvedor(desenvolvedor);

        response.sendRedirect("desenvolvedores");
    }

    private void deletarDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        desenvolvedorDAO.deletarDesenvolvedor(id);

        response.sendRedirect("desenvolvedores");
    }
}
