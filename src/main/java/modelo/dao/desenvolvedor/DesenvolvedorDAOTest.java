import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.entidade.desenvolvedor.Desenvolvedor;
import modelo.entidade.usuario.Usuario;
import modelo.enumeracao.funcaodesenvolvedor.FuncaoDesenvolvedor;

public class DesenvolvedorDAOTest {

    private SessionFactory sessionFactory;
    private Session session;
    private DesenvolvedorDAO desenvolvedorDAO;

    @Before
    public void setUp() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        session = sessionFactory.openSession();
        desenvolvedorDAO = new DesenvolvedorDAO(session);
    }

    @After
    public void tearDown() {
        if (session != null) session.close();
        if (sessionFactory != null) sessionFactory.close();
    }

    @Test
    public void testSalvarDesenvolvedor() {
        // Criando usuário para associar com o desenvolvedor
        Usuario usuario = new Usuario();
        usuario.setEmail("dev@exemplo.com");
        usuario.setSenha("senha123");

        Desenvolvedor desenvolvedor = new Desenvolvedor();
        desenvolvedor.setCpf("12345678901");
        desenvolvedor.setNomeDesenvolvedor("João");
        desenvolvedor.setUsuario(usuario);
        desenvolvedor.setFuncao(FuncaoDesenvolvedor.DEV);

        session.beginTransaction();
        desenvolvedorDAO.salvar(desenvolvedor);
        session.getTransaction().commit();

        Desenvolvedor desenvolvedorSalvo = desenvolvedorDAO.buscarPorId(desenvolvedor.getCpf());
        assertNotNull(desenvolvedorSalvo);
        assertEquals("João", desenvolvedorSalvo.getNomeDesenvolvedor());
        assertEquals("dev@exemplo.com", desenvolvedorSalvo.getUsuario().getEmail());
    }
}
