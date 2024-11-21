package modelo.dao.desenvolvedor;

import java.util.List;

import modelo.entidade.desenvolvedor.Desenvolvedor;

public interface DesenvolvedorDAO {

	boolean inserirDesenvolvedor(Desenvolvedor desenvolvedor);

	boolean deletarDesenvolvedor(Desenvolvedor desenvolvedor);

	boolean atualizarDesenvolvedor(Desenvolvedor desenvolvedor);
	
	Desenvolvedor recuperarDesenvolvedorPorIdUsaurio(Long id);

	List<Desenvolvedor> recuperarDesenvolvedores();

}