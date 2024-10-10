package br.senai.taskflow.modelo.dao.Desenvolvedor;

import br.senai.taskflow.modelo.entidade.desenvolvedor.Desenvolvedor;
import java.util.List;

public interface DesenvolvedorDAO {
    void cadastrarDesenvolvedor(Desenvolvedor desenvolvedor);
    void alterarDesenvolvedor(Desenvolvedor desenvolvedor);
    void deletarDesenvolvedor(Desenvolvedor desenvolvedor);
    Desenvolvedor consultarDesenvolvedor(Long id);
    List<Desenvolvedor> listarDesenvolvedores();
}
