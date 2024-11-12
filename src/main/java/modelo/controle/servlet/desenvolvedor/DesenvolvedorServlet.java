package modelo.controle.servlet.desenvolvedor;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.desenvolvedor.DesenvolvedorDAO;
import modelo.dao.desenvolvedor.DesenvolvedorDAOImpl;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.desenvolvedor.Desenvolvedor;
import modelo.entidade.usuario.Usuario;
import modelo.enumeracao.funcaodesenvolvedor.FuncaoDesenvolvedor;

@WebServlet(urlPatterns = {"/cadastrar-desenvolvedor", "/inserir-desenvolvedor"})
public class DesenvolvedorServlet extends HttpServlet implements Serializable{

	private static final long serialVersionUID = 1L;
    private DesenvolvedorDAO daoDesenvolvedor;
    private UsuarioDAO daoUsuario;
	
    public void init() {
		daoDesenvolvedor = new DesenvolvedorDAOImpl();
		daoUsuario = new UsuarioDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		try {
			
			switch (action) {
			
			case "/cadastrar-desenvolvedor":
				mostrarCadastroDesenvolvedor(request, response);
				break;
			
			case "/inserir-desenvolvedor":
				inserirDesenvolvedor(request, response);
				break;
			
			default:
				retornarMenu(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void mostrarCadastroDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/desenvolvedor/cadastrar-desenvolvedor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void retornarMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void inserirDesenvolvedor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		
		daoUsuario.inserirUsuario(usuario);
		
		Desenvolvedor desenvolvedor = new Desenvolvedor();
		
		desenvolvedor.setCpf(request.getParameter("cpf"));
		desenvolvedor.setNomeDesenvolvedor(request.getParameter("nome"));
		desenvolvedor.setFuncao(FuncaoDesenvolvedor.valueOf(request.getParameter("funcao")));
		desenvolvedor.setUsuario(usuario);
		
		
		daoDesenvolvedor.inserirDesenvolvedor(desenvolvedor);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("paginas/desenvolvedor/home-dev.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
