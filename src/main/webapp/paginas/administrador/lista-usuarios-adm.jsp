<%@page import="modelo.dao.desenvolvedor.DesenvolvedorDAOImpl"%>
<%@page import="modelo.entidade.desenvolvedor.Desenvolvedor"%>
<%@page import="modelo.entidade.usuario.Usuario"%>
<%@page import="modelo.dao.usuario.UsuarioDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tabela Estilizada</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f0f4f8;
      margin: 0;
    }

    .table-container {
      max-width: 2500px;
      margin: 20px;
      border-radius: 8px;
      overflow: hidden;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      padding: 12px 30px;
      text-align: left;
    }

    thead {
      background-color: #3f87a6;
      color: #fff;
    }

    tbody tr:nth-child(even) {
      background-color: #e4f1f7;
    }

    tbody tr:nth-child(odd) {
      background-color: #ffffff;
    }

    tbody tr:hover {
      background-color: #d3ebf7;
    }

    th {
      font-size: 16px;
      font-weight: bold;
      border-bottom: 2px solid #d3ebf7;
    }

    td {
      font-size: 14px;
      color: #333;
    }
  </style>
</head>
<body>
  <div class="table-container">
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Email</th>
          <th>Função</th>
          <th>CPF</th>
          <th>Bloquado</th>
          <th>Administrador</th>
          <th>Inativo</th>
          
        </tr>
      </thead>
      <tbody>
        <%
        	UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        	DesenvolvedorDAOImpl desenvolvedorDAO = new DesenvolvedorDAOImpl();
        	
        	for(Usuario usuario : usuarioDAO.recuperarUsuarios()){
        		for(Desenvolvedor desenvolvedor : desenvolvedorDAO.recuperarDesenvolvedores()){
        			if(usuario.getIdUsuario() == desenvolvedor.getUsuario().getIdUsuario()){
        				%>
            				<tr>
            					<td><%= usuario.getIdUsuario() %></td>
            					<td><%= desenvolvedor.getNomeDesenvolvedor() %></td>
            					<td><%= usuario.getEmail() %></td>
            					<td><%= desenvolvedor.getFuncao() %></td>
            					<td><%= desenvolvedor.getCpf() %></td>
            					<td><%= usuario.isBloqueado() %></td>
            					<td><%= usuario.isAdministrador() %></td>
            					<td><%= usuario.isInativo() %>
            				</tr>
            			<% 
        			}

        		}
        	
        	}
        			
        %>
      </tbody>
    </table>
  </div>
</body>
</html>
