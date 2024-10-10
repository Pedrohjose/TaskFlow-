package br.senai.taskflow.modelo.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConexaoFactory {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Configuração do Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // carrega o arquivo de configuração do Hibernate
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log a exceção
            System.err.println("Falha na criação da SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método para obter a SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Método para fechar a SessionFactory
    public static void shutdown() {
        // Fechar caches e pools de conexão
        getSessionFactory().close();
    }
}
