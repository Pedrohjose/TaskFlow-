<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Administrador</title>
</head>
<body>
<h1>Home Administrador</h1>
<a href="<%= request.getContextPath()%>/index.jsp">Voltar</a>
<a href="<%= request.getContextPath()%>/paginas/administrador/lista-usuarios-adm.jsp">Usuarios</a>
<a href="<%= request.getContextPath()%>/lista-tarefas-adm.jsp">Tarefas</a>
</body>
</html>