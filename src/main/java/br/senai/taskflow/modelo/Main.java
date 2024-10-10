package br.senai.taskflow.modelo;

import br.senai.taskflow.modelo.dao.Usuario.*;
import br.senai.taskflow.modelo.dao.Desenvolvedor.*;
import br.senai.taskflow.modelo.dao.TipoTarefa.*;
import br.senai.taskflow.modelo.dao.Tarefa.*;
import br.senai.taskflow.modelo.entidade.usuario.Usuario;
import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;
import br.senai.taskflow.modelo.entidade.tarefa.TipoTarefa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Testando Usuário
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setAtivo(true);
        usuarioDAO.cadastrarUsuario(usuario);

        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        System.out.println("Lista de Usuários:");
        for (Usuario u : usuarios) {
            System.out.println(u);
        }

        // Testando Desenvolvedor
        DesenvolvedorDAOImpl desenvolvedorDAO = new DesenvolvedorDAOImpl();
        
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        desenvolvedor.setNome("Maria");
        desenvolvedor.setEmail("maria@example.com");
        desenvolvedorDAO.cadastrarDesenvolvedor(desenvolvedor);

        List<Desenvolvedor> desenvolvedores = desenvolvedorDAO.listarDesenvolvedores();
        System.out.println("Lista de Desenvolvedores:");
        for (Desenvolvedor d : desenvolvedores) {
            System.out.println(d);
        }

        // Testando Tipo de Tarefa
        TipoTarefaDAOImpl tipoTarefaDAO = new TipoTarefaDAOImpl();
        
        TipoTarefa tipoTarefa = new TipoTarefa();
        tipoTarefa.setDescricao("Desenvolvimento");
        tipoTarefaDAO.cadastrarTipoTarefa(tipoTarefa);

        List<TipoTarefa> tiposTarefa = tipoTarefaDAO.listarTiposTarefa();
        System.out.println("Lista de Tipos de Tarefa:");
        for (TipoTarefa tt : tiposTarefa) {
            System.out.println(tt);
        }

        // Testando Tarefa
        TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();
        
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao("Implementar nova funcionalidade");
        tarefa.setDesenvolvedor(desenvolvedor); // associando ao desenvolvedor
        tarefa.setTipoTarefa(tipoTarefa); // associando ao tipo de tarefa
        tarefaDAO.cadastrarTarefa(tarefa);

        List<Tarefa> tarefas = tarefaDAO.listarTarefas();
        System.out.println("Lista de Tarefas:");
        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
    }
}
