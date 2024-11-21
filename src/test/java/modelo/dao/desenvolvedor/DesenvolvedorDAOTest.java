package modelo.dao.desenvolvedor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.desenvolvedor.Desenvolvedor;
import modelo.entidade.usuario.Usuario;
import modelo.enumeracao.funcaodesenvolvedor.FuncaoDesenvolvedor;

public class DesenvolvedorDAOTest {

    private DesenvolvedorDAO desenvolvedorDAO;
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        desenvolvedorDAO = new DesenvolvedorDAOImpl();
        usuarioDAO = new UsuarioDAOImpl();
    }

    @Test
    public void testCreateDesenvolvedor() {
		Usuario usuario = new Usuario();
		
		usuario.setEmail("john.doe@gmail.com");
		usuario.setSenha("senha123");
		
		DesenvolvedorDAOImpl desenvolvedorDAO = new DesenvolvedorDAOImpl();
		Desenvolvedor desenvolvedor = new Desenvolvedor();
		
		desenvolvedor.setFuncao(FuncaoDesenvolvedor.BACK_END);
		desenvolvedor.setNomeDesenvolvedor("John Doe");
		desenvolvedor.setUsuario(usuario);
		desenvolvedor.setCpf("12312312321");
		
		usuarioDAO.inserirUsuario(usuario);
		

        boolean created = desenvolvedorDAO.inserirDesenvolvedor(desenvolvedor);
        assertTrue(created, "O desenvolvedor deveria ser criado com sucesso.");
    }

    @Test
    public void testReadDesenvolvedor() {
        Desenvolvedor desenvolvedor = desenvolvedorDAO.recuperarDesenvolvedorPorIdUsaurio(1L);
        assertNotNull(desenvolvedor, "O desenvolvedor com ID 1 deveria existir.");
        assertEquals("John Doe", desenvolvedor.getNomeDesenvolvedor(), "Nome do desenvolvedor deveria ser 'John Doe'.");
    }

    @Test
    public void testUpdateDesenvolvedor() {
        Desenvolvedor desenvolvedor = desenvolvedorDAO.recuperarDesenvolvedorPorIdUsaurio(1L);
        assertNotNull(desenvolvedor, "O desenvolvedor com ID 1 deveria existir.");

        desenvolvedor.setNomeDesenvolvedor("Joes Doe");
        boolean updated = desenvolvedorDAO.atualizarDesenvolvedor(desenvolvedor);
        assertTrue(updated, "O desenvolvedor deveria ser atualizado com sucesso.");

        Desenvolvedor updatedDesenvolvedor = desenvolvedorDAO.recuperarDesenvolvedorPorIdUsaurio(1L);
        assertEquals("Joes Doe", updatedDesenvolvedor.getNomeDesenvolvedor(), "A função do desenvolvedor deveria ser atualizada para 'Frontend Developer'.");
    }
    
    @Test
    public void testDeleteDesenvolvedor() {
        Desenvolvedor desenvolvedor = desenvolvedorDAO.recuperarDesenvolvedorPorIdUsaurio(1L);
    	
    	boolean deleted = desenvolvedorDAO.deletarDesenvolvedor(desenvolvedor); 
        assertTrue(deleted, "O desenvolvedor com ID 1 deveria ser deletado com sucesso.");

        Desenvolvedor desenvolvedorDeletado = desenvolvedorDAO.recuperarDesenvolvedorPorIdUsaurio(1L);
        assertNull(desenvolvedorDeletado, "O desenvolvedor com ID 1 não deveria mais existir.");
    }

    
}
