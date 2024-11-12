package modelo.principal;


import modelo.dao.desenvolvedor.DesenvolvedorDAOImpl;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.desenvolvedor.Desenvolvedor;
import modelo.entidade.usuario.Usuario;
import modelo.enumeracao.funcaodesenvolvedor.FuncaoDesenvolvedor;

public class Main {

    public static void main(String[] args) {
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario = new Usuario();
        
        usuario.setEmail("pedro@gmail.com");
        usuario.setSenha("123");
        
        usuarioDAO.inserirUsuario(usuario);
        
        DesenvolvedorDAOImpl desenvolvedorDAO = new DesenvolvedorDAOImpl();
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        
        desenvolvedor.setCpf("12312312312");
        desenvolvedor.setFuncao(FuncaoDesenvolvedor.BACK_END);
        desenvolvedor.setNomeDesenvolvedor("Marcio Shoenflder");
        desenvolvedor.setUsuario(usuario);
        
        desenvolvedorDAO.inserirDesenvolvedor(desenvolvedor);
        
        
        
        
        
    }

}
