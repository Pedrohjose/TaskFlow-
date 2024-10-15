package br.senai.taskflow.modelo;

import java.time.LocalDate;

import br.senai.taskflow.modelo.dao.Desenvolvedor.DesenvolvedorDAOImpl;
import br.senai.taskflow.modelo.dao.Tarefa.TarefaDAOImpl;
import br.senai.taskflow.modelo.dao.Usuario.UsuarioDAOImpl;
import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.taskflow.modelo.entidade.tarefa.Tarefa;
import br.senai.taskflow.modelo.entidade.tarefa.TipoTarefa;
import br.senai.taskflow.modelo.entidade.usuario.Usuario;
import br.senai.taskflow.modelo.enumeracao.StatusTarefa.StatusTarefa;

public class Main {
    public static void main(String[] args) {
        // Criando instâncias dos DAOs
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        DesenvolvedorDAOImpl desenvolvedorDAO = new DesenvolvedorDAOImpl();
        TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();

        // Cadastrando um usuário
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setSenha("123");
        usuario.setAtivo(true);
        usuarioDAO.cadastrarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!");

        // Cadastrando um desenvolvedor
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        desenvolvedor.setNome("Maria");
        desenvolvedor.setEmail("maria@example.com");
        desenvolvedor.setMatricula("123456"); // Definindo matrícula
        desenvolvedorDAO.cadastrarDesenvolvedor(desenvolvedor);
        System.out.println("Desenvolvedor cadastrado com sucesso!");


        TipoTarefa tipoTarefa = new TipoTarefa();
        tipoTarefa.setDescricao("Desenvolvimento"); 
        
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Implementar funcionalidade X");
        tarefa.setDescricao("Descrever a funcionalidade X que deve ser implementada.");
        tarefa.setStatus(StatusTarefa.EM_ANDAMENTO); // Definindo o status da tarefa
        tarefa.setUsuario(usuario); // Atribuindo o usuário à tarefa
        tarefa.setDesenvolvedor(desenvolvedor); // Atribuindo o desenvolvedor à tarefa
        tarefa.setTipoTarefa(tipoTarefa); // Atribuindo o tipo de tarefa
        tarefa.setDataCriacao(LocalDate.now()); // Definindo a data de criação
        tarefa.setPrazo(LocalDate.now().plusDays(7)); // Definindo o prazo

        tarefaDAO.cadastrarTarefa(tarefa); // Método de cadastro da tarefa
        System.out.println("Tarefa cadastrada com sucesso!");
    }
}
