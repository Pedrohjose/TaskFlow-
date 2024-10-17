package br.senai.taskflow.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.taskflow.modelo.dao.Usuario.UsuarioDAOImpl;
import br.senai.taskflow.modelo.entidade.usuario.Usuario;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
    

	private static final long serialVersionUID = 4660393201828506977L;
	private UsuarioDAOImpl usuarioDAO;

    public void init() {
        usuarioDAO = new UsuarioDAOImpl();  // Inicializa o DAO de Usuario
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);  // Encaminha as requisições POST para o método GET
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/novoUsuario":
                    mostrarFormularioNovoUsuario(request, response);
                    break;
                case "/inserirUsuario":
                    inserirUsuario(request, response);
                    break;
                case "/deletarUsuario":
                    deletarUsuario(request, response);
                    break;
                case "/editarUsuario":
                    mostrarFormularioEditarUsuario(request, response);
                    break;
                case "/atualizarUsuario":
                    atualizarUsuario(request, response);
                    break;
                default:
                    listarUsuarios(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // Método para listar os usuários
    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuario> listaUsuarios = usuarioDAO.listarUsuarios();
        request.setAttribute("listaUsuarios", listaUsuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario-lista.jsp");
        dispatcher.forward(request, response);
    }

    // Método para mostrar o formulário de cadastro de um novo usuário
    private void mostrarFormularioNovoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario-formulario.jsp");
        dispatcher.forward(request, response);
    }

    // Método para inserir um novo usuário
    private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario novoUsuario = new Usuario(nome, email, senha, true); // Pode ajustar os parâmetros conforme seu modelo
        usuarioDAO.cadastrarUsuario(novoUsuario);
        response.sendRedirect("usuario");
    }

    // Método para deletar um usuário
    private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = usuarioDAO.consultarUsuario(id); // Busca o usuário
        if (usuario != null) {
            usuarioDAO.deletarUsuario(id);
        }
        response.sendRedirect("usuario");
    }

    // Método para mostrar o formulário de edição de um usuário
    private void mostrarFormularioEditarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuarioExistente = usuarioDAO.consultarUsuario(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario-formulario.jsp");
        request.setAttribute("usuario", usuarioExistente);
        dispatcher.forward(request, response);
    }

    // Método para atualizar um usuário
    private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuarioAtualizado = usuarioDAO.consultarUsuario(id);
        if (usuarioAtualizado != null) {
            usuarioAtualizado.setNome(nome);
            usuarioAtualizado.setEmail(email);
            usuarioAtualizado.setSenha(senha);
            usuarioDAO.alterarUsuario(usuarioAtualizado);
        }

        response.sendRedirect("usuario");
    }
}
