package modelo.principal;


import java.time.LocalDate;

import modelo.dao.desenvolvedor.DesenvolvedorDAOImpl;
import modelo.dao.tarefa.TarefaDAOImpl;
import modelo.dao.tipotarefa.TipoTarefaDAOImpl;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.desenvolvedor.Desenvolvedor;
import modelo.entidade.tarefa.Tarefa;
import modelo.entidade.tipotarefa.TipoTarefa;
import modelo.entidade.usuario.Usuario;
import modelo.enumeracao.categoria.Categoria;
import modelo.enumeracao.funcaodesenvolvedor.FuncaoDesenvolvedor;
import modelo.enumeracao.status.StatusTarefa;

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
        
        TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();
        Tarefa tarefa = new Tarefa();
        
        tarefa.setNomeTarefa("Implementar Login");
        tarefa.setDescricao("Implementar a funcionalidade de login no sistema.");
        tarefa.setStatus(StatusTarefa.EM_ANDAMENTO);
        tarefa.setDataCriacao(LocalDate.now());
        tarefa.setDataPrazo(LocalDate.now().plusDays(10)); 
        tarefa.setDataConclusao(LocalDate.now().plusDays(5));
                
        tarefaDAO.inserirTarefa(tarefa);

        System.out.println("Tarefa inserida com sucesso!");

        
        TipoTarefaDAOImpl tipoTarefaDAO = new TipoTarefaDAOImpl();
		TipoTarefa tipoTarefa = new TipoTarefa();
        
		tipoTarefa.setTarefa(tarefa); 
        tipoTarefa.setPrioridade(2); 
        tipoTarefa.setCategoria(Categoria.TRABALHO);
        tipoTarefaDAO.inserirTipoTarefa(tipoTarefa);

        System.out.println("TipoTarefa inserido com sucesso!");

        
        
        
    }

}
