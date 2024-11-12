package modelo.dao.desenvolvedor;

import java.util.List;

import modelo.entidade.desenvolvedor.Desenvolvedor;

public interface DesenvolvedorDAO {

	void inserirDesenvolvedor(Desenvolvedor desenvolvedor);

	void deletarDesenvolvedor(Desenvolvedor desenvolvedor);

	void atualizarDesenvolvedor(Desenvolvedor desenvolvedor);

	List<Desenvolvedor> recuperarDesenvolvedores();

}