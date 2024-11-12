import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.entidade.usuario.Usuario;

public class UsuarioDAOTest {

    private SessionFactory sessionFactory;
    private Session session;
    private UsuarioDAO usuarioDAO;

    @Before
    public void setUp() {
        // Configuração do Hibernate com banco H2 para testes em memória
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Aponte para o seu hibernate.cfg.xml configurado para H2
                .buildSessionFactory();
        session = sessionFactory.openSession();
        usuarioDAO = new UsuarioDAO(session);
    }

    @After
    public void tearDown() {
        if (session != null) session.close();
        if (sessionFactory != null) sessionFactory.close();
    }

    @Test
    public void testSalvarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setEmail("teste@exemplo.com");
        usuario.setSenha("senha123");

        session.beginTransaction();
        usuarioDAO.salvar(usuario);
        session.getTransaction().commit();

        Usuario usuarioSalvo = usuarioDAO.buscarPorId(usuario.getIdUsuario());
        assertNotNull(usuarioSalvo);
        assertEquals("teste@exemplo.com", usuarioSalvo.getEmail());
    }

    @Test
    public void testAtualizarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setEmail("teste@exemplo.com");
        usuario.setSenha("senha123");

        session.beginTransaction();
        usuarioDAO.salvar(usuario);
        session.getTransaction().commit();

        // Atualizar dados do usuário
        usuario.setSenha("novaSenha");
        session.beginTransaction();
        usuarioDAO.atualizar(usuario);
        session.getTransaction().commit();

        Usuario usuarioAtualizado = usuarioDAO.buscarPorId(usuario.getIdUsuario());
        assertEquals("novaSenha", usuarioAtualizado.getSenha());
    }

    @Test
    public void testDeletarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setEmail("delete@exemplo.com");
        usuario.setSenha("senha123");

        session.beginTransaction();
        usuarioDAO.salvar(usuario);
        session.getTransaction().commit();

        session.beginTransaction();
        usuarioDAO.deletarUsuario(usuario);
        session.getTransaction().commit();

        Usuario usuarioDeletado = usuarioDAO.buscarPorId(usuario.getIdUsuario());
        assertNull(usuarioDeletado);
    }
}
