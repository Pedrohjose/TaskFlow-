<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Desenvolvedor</title>
</head>
<body>
<h1>Home Desenvolvedor</h1>
<h1>Bem-vindo ao Sistema de Gestão de Tarefas</h1>
    <div class="button-container">
        <!-- Botão para listar tarefas -->
        <a href="listar-tarefas" class="button">Listar Tarefas</a>

        <!-- Botão para cadastrar uma nova tarefa -->
        <a href="cadastrar-tarefa.jsp" class="button">Cadastrar Nova Tarefa</a>

    </div>
<a href="<%= request.getContextPath()%>/index.jsp">Voltar</a>
</body>
</html>