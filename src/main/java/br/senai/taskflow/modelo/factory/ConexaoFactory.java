package br.senai.taskflow.modelo.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {
                // Criando a configuração do Hibernate
                Configuration configuracao = new Configuration();

                // Adicionando as classes anotadas do seu sistema
                configuracao.addAnnotatedClass(br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor.class);
                configuracao.addAnnotatedClass(br.senai.taskflow.modelo.entidade.tarefa.Tarefa.class);
                configuracao.addAnnotatedClass(br.senai.taskflow.modelo.entidade.usuario.Usuario.class);
                configuracao.addAnnotatedClass(br.senai.taskflow.modelo.entidade.tarefa.Tarefa.class);
                configuracao.addAnnotatedClass(br.senai.taskflow.modelo.entidade.tarefa.TipoTarefa.class);

                configuracao.configure("hibernate.cfg.xml");

                ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
                return configuracao.buildSessionFactory(servico);
    }
}
