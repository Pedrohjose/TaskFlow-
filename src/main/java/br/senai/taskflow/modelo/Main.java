package br.senai.taskflow.modelo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import br.senai.taskflow.modelo.dao.Desenvolvedor.DesenvolvedorDAOImpl;
import br.senai.taskflow.modelo.dao.Tarefa.TarefaDAOImpl;
import br.senai.taskflow.modelo.dao.TipoTarefa.TipoTarefaDAOImpl;
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
        TipoTarefaDAOImpl tipoTarefaDAO = new TipoTarefaDAOImpl();

        // Lista de usuários a serem cadastrados
        List<Usuario> usuarios = Arrays.asList(
            new Usuario("João", "joao@example.com", "123", true),
            new Usuario("Ana", "ana@example.com", "123", true),
            new Usuario("Carlos", "carlos@example.com", "123", true)
        );

        // Cadastrando os usuários
        for (Usuario usuario : usuarios) {
            usuarioDAO.cadastrarUsuario(usuario);
            System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso!");
        }

        // Lista de desenvolvedores a serem cadastrados
        List<Desenvolvedor> desenvolvedores = Arrays.asList(
            new Desenvolvedor("Maria", "maria@example.com", "123456"),
            new Desenvolvedor("Paulo", "paulo@example.com", "654321"),
            new Desenvolvedor("Fernanda", "fernanda@example.com", "987654")
        );

        // Cadastrando os desenvolvedores
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            desenvolvedorDAO.cadastrarDesenvolvedor(desenvolvedor);
            System.out.println("Desenvolvedor " + desenvolvedor.getNome() + " cadastrado com sucesso!");
        }

        // Criando e cadastrando o tipo de tarefa
        TipoTarefa tipoTarefa = new TipoTarefa();
        tipoTarefa.setDescricao("Desenvolvimento");

        // Salvando o tipo de tarefa no banco de dados
        tipoTarefaDAO.cadastrarTipoTarefa(tipoTarefa);
        System.out.println("Tipo de tarefa cadastrado com sucesso!");

        // Criar uma tarefa para cada usuário e desenvolvedor
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            Desenvolvedor desenvolvedor = desenvolvedores.get(i);

            // Verificando se o desenvolvedor já foi salvo no banco de dados
            Desenvolvedor desenvolvedorSalvo = desenvolvedorDAO.buscarPorEmail(desenvolvedor.getEmail());
            if (desenvolvedorSalvo == null) {
                // Salvando o desenvolvedor, caso ainda não tenha sido salvo
                desenvolvedorDAO.cadastrarDesenvolvedor(desenvolvedor);
                desenvolvedorSalvo = desenvolvedor;
            }

            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo("Tarefa " + (i + 1) + ": Implementar funcionalidade " + (char) ('A' + i));
            tarefa.setDescricao("Descrição da tarefa " + (i + 1));
            tarefa.setStatus(StatusTarefa.EM_ANDAMENTO); // Definindo o status da tarefa
            tarefa.setUsuario(usuario); // Atribuindo o usuário à tarefa
            tarefa.setDesenvolvedor(desenvolvedorSalvo); // Atribuindo o desenvolvedor já salvo à tarefa
            tarefa.setTipoTarefa(tipoTarefa); // Atribuindo o tipo de tarefa
            tarefa.setDataCriacao(LocalDate.now()); // Definindo a data de criação
            tarefa.setPrazo(LocalDate.now().plusDays(7 + i)); // Definindo o prazo

            // Cadastrando a tarefa no banco de dados
            tarefaDAO.cadastrarTarefa(tarefa);
            System.out.println("Tarefa cadastrada com sucesso para o usuário " + usuario.getNome() +
                               " e desenvolvedor " + desenvolvedorSalvo.getNome());
        }
    }
}
