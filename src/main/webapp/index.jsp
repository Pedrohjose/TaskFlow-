<%@page import="modelo.entidade.usuario.Usuario"%>
<%@page import="modelo.dao.usuario.UsuarioDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/estilos/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Entrar na Conta</h2>
        <form action="logar-usuario" method="post">
            <div class="input-field">
                <input type="email" id="email" name="email" placeholder="Digite seu email" required>
            </div>
            <div class="input-field">
                <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required>
            </div>
            <button type="submit" class="button">Entrar</button>
            <div class="forgot-password">
                <p>Não possui cadastro? <a href="cadastrar-desenvolvedor">Cadastrar</a></p>
            </div>
            <%
        	UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        	String emailSessao = (String) session.getAttribute("emailSessao");
        	
        	for(Usuario usuario : usuarioDAO.recuperarUsuarios()){
        		if(usuario.getEmail().equals(emailSessao) && usuario.isBloqueado()){
        			%>
        			<div class="forgot-password">
                		<p>Conta Bloqueada <a href="redefinir-senha">Resetar Senha</a></p>
            		</div>
        			<% 
        		}
        	}
        	
        %>
        </form>
    </div>
</body>
</html>

