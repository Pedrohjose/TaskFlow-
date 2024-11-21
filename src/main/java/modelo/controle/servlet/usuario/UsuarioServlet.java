package modelo.controle.servlet.usuario;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.dao.desenvolvedor.DesenvolvedorDAO;
import modelo.dao.desenvolvedor.DesenvolvedorDAOImpl;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.desenvolvedor.Desenvolvedor;
import modelo.entidade.usuario.Usuario;

@WebServlet(urlPatterns = {"/logar-usuario", "/redefinir-senha", "/desbloquear-usuario"})
public class UsuarioServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	private UsuarioDAO daoUsuario;
	private DesenvolvedorDAO daoDesenvolvedor;

	public void init() {
		daoUsuario = new UsuarioDAOImpl();
		daoDesenvolvedor = new DesenvolvedorDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

			switch (action) {

			case "/logar-usuario":
				logarUsuario(request, response);
				break;

			case "/redefinir-senha":
				mostrarResetarSenha(request, response);
				break;
				
			case "/desbloquear-usuario":
				desbloquearUsuario(request, response);
				break;
				
			default:
				retornarMenu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void retornarMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarResetarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/desenvolvedor/resetar-senha-desenvolvedor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		session.setAttribute("emailSessao", email);

		for (Usuario usuarios : daoUsuario.recuperarUsuarios()) {
			if (usuarios.getEmail().equals(email) && usuarios.getSenha().equals(senha)) {

				if (usuarios.isBloqueado() || usuarios.isInativo()) {
					System.out.println("Usuario Não pode Acessar o Sistema");
					break;
				}

				Usuario usuario = usuarios;
				usuario.setTentativas(0);
				daoUsuario.atualizarUsuario(usuario);
				
				Desenvolvedor desenvolvedor = daoDesenvolvedor.recuperarDesenvolvedorPorIdUsaurio(usuario.getIdUsuario());
				
				session.setAttribute("usuario", usuario);
				session.setAttribute("desenvolvedor", desenvolvedor);
				
				if (usuarios.isAdministrador()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/administrador/home-adm.jsp");
					dispatcher.forward(request, response);
					return;
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/desenvolvedor/home-dev.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}else if (usuarios.getEmail().equals(email)) {

				
				Usuario usuario = new Usuario();
				usuario = usuarios;
				usuario.setTentativas(usuarios.getTentativas() + 1);

				if (usuario.getTentativas() >= 3) {
					usuario.setBloqueado(true);
				}

				daoUsuario.atualizarUsuario(usuario);
				break;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}
	
	private void desbloquearUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		
		String emailSessao = (String) session.getAttribute("emailSessao");
		
		for (Usuario usuario : daoUsuario.recuperarUsuarios()) {
			if (usuario.getEmail().equals(emailSessao)) {
				usuario.setSenha(request.getParameter("senha"));
				usuario.setBloqueado(false);
				usuario.setTentativas(0);
				daoUsuario.atualizarUsuario(usuario);
				
				if(usuario.isInativo()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					return;
				}
				
				if (usuario.isAdministrador()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/administrador/home-adm.jsp");
					dispatcher.forward(request, response);
					break;
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/desenvolvedor/home-dev.jsp");
					dispatcher.forward(request, response);
					break;
				}
			}
		}
		
		
	}

}
