<%@page import="modelo.dao.tarefa.TarefaDAOImpl"%>
<%@page import="modelo.entidade.tarefa.Tarefa"%>
<%@page import="modelo.entidade.tipotarefa.TipoTarefa"%>
<%@page import="modelo.dao.tipotarefa.TipoTarefaDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Long idTipoTarefa = Long.parseLong(request.getParameter("idTipoTarefa"));
    	
    	TipoTarefaDAOImpl tipoTarefaDAO = new TipoTarefaDAOImpl();
    	TipoTarefa tipoTarefa = tipoTarefaDAO.recuperarTipoTarefaPorIdUsaurio(idTipoTarefa);
    	
    	TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();
    	Tarefa tarefa = tarefaDAO.recuperarTarefaPorIdUsaurio(tipoTarefa.getTarefa().getIdTarefa());
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar de Tarefa</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/estilos/criar-tarefa.css">    
</head>
<body>
    <div class="modal-container">
        <h2>Edição de Tarefa</h2>
        <form id="form-tarefa" action="alterar-tarefa" method="post">
            <div class="input-field">
                <label for="nomeTarefa">Nome da Tarefa:</label>
                <input type="text" id="nomeTarefa" name="nomeTarefa" placeholder="Nome da tarefa" value="<%=tarefa.getNomeTarefa() %>" required>
            </div>
            <div class="input-field">
                <label for="descricao">Descrição:</label>
                <input type="text" id="descricao" name="descricao" placeholder="Descrição da tarefa" value="<%=tarefa.getDescricao() %>" required>
            </div>
            <div class="input-field">
                <label for="dataPrazo">Data do Prazo:</label>
                <input type="date" id="dataPrazo" name="dataPrazo" value="<%=tarefa.getDataPrazo() %>" required>
            </div>
            <div class="input-field">
                <label for="status">Status:</label>
                <select id="status" name="status" required>
                    <option value="EM_ANDAMENTO">Em Andamento</option>
                    <option value="CONCLUIDO">Concluída</option>
                    <option value="PENDENTE">Pendente</option>
                </select>
            </div>
            <div class="input-field">
                <label for="prioridade">Prioridade:</label>
                <input type="number" id="prioridade" name="prioridade" value="<%=tipoTarefa.getPrioridade() %>" placeholder="Ex: 1" min="1" required>
            </div>
            <div class="input-field">
                <label for="categoria">Categoria:</label>
                <select id="categoria" name="categoria" required>
                    <option value="ESTUDO">Estudo</option>
                    <option value="TRABALHO">Trabalho</option>
                    <option value="PESSOAL">Pessoal</option>
                </select>
            </div>
            <input type="hidden" name="idTipoTarefa" value="<%= tipoTarefa.getIdTipoTarefa() %>">
            <button type="submit" class="button">Salvar</button>
        </form>
    </div>
</body>

</html>