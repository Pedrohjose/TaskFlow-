<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign up</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/estilos/login.css">
</head>
<body>
	<div class="login-container">
		<h2>Sign up</h2>
		<form id="form-cadastro" action="inserir-desenvolvedor" method="post">
			<div class="input-field">
				<input type="text" id="nome" name="nome" placeholder="Digite seu nome" required>
			</div>
			<div class="input-field">
				<input type="email" id="email" name="email" placeholder="Digite seu email" required>
			</div>
			<div class="input-field">
				<input type="password" id="senha" name="senha" placeholder="Digite sua senha" required>
			</div>
			<div class="input-field">
				<input type="password" id="senha-confirm" name="senha-confirm" placeholder="Confirme sua senha" required>
			</div>
			<div class="input-field">
				<input type="text" id="cpf" name="cpf" required maxlength="14" placeholder="000.000.000-00">
			</div>
			<div class="input-field">
				<label for="funcao">Função:</label>
				<select id="funcao" name="funcao" required>
					<option value="BACK_END">Back-End</option>
					<option value="FRONT_END">Front-End</option>
					<option value="BANCO_DE_DADOS">Banco de Dados</option>
					<option value="FULL_STACK">Full Stack</option>
				</select>
			</div>
			<button type="submit" class="button">Sign up</button>
			<div class="forgot-password">
                <p>Possui conta? <a href="index.jsp">Login</a></p>
            </div>
		</form>
	</div>
<script src="<%=request.getContextPath()%>/resources/scripts/login.js">
</script>
</body>
</html>
