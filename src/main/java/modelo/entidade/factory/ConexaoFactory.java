package modelo.entidade.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {
	
	public SessionFactory getConexao() {
		Configuration configuracao = new Configuration();
		
		configuracao.addAnnotatedClass(modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(modelo.entidade.desenvolvedor.Desenvolvedor.class);
		configuracao.addAnnotatedClass(modelo.entidade.tarefa.Tarefa.class);
		configuracao.addAnnotatedClass(modelo.entidade.tipotarefa.TipoTarefa.class);
		
		configuracao.configure("hibernet.cfg.xml");
		
		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao  = configuracao.buildSessionFactory(servico);
		
		return fabricaSessao;
	}
}
