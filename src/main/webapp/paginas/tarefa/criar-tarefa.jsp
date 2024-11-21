<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Tarefa</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/estilos/criar-tarefa.css">    
</head>
<body>
    <div class="modal-container">
        <h2>Cadastro de Tarefa</h2>
        <form id="form-tarefa" action="inserir-tarefa" method="post">
            <div class="input-field">
                <label for="nomeTarefa">Nome da Tarefa:</label>
                <input type="text" id="nomeTarefa" name="nomeTarefa" placeholder="Nome da tarefa" required>
            </div>
            <div class="input-field">
                <label for="descricao">Descrição:</label>
                <input type="text" id="descricao" name="descricao" placeholder="Descrição da tarefa" required>
            </div>
            <div class="input-field">
                <label for="dataPrazo">Data do Prazo:</label>
                <input type="date" id="dataPrazo" name="dataPrazo" required>
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
                <input type="number" id="prioridade" name="prioridade" placeholder="Ex: 1" min="1" required>
            </div>
            <div class="input-field">
                <label for="categoria">Categoria:</label>
                <select id="categoria" name="categoria" required>
                    <option value="ESTUDO">Estudo</option>
                    <option value="TRABALHO">Trabalho</option>
                    <option value="PESSOAL">Pessoal</option>
                </select>
            </div>
            <button type="submit" class="button">Cadastrar</button>
        </form>
    </div>
</body>

</html>