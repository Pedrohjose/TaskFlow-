<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resetar Senha</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/estilos/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Resetar Senha</h2>
        <form id="resetForm" action="desbloquear-usuario" method="post">
            <div class="input-field">
				<input type="password" id="senha" name="senha" placeholder="Digite sua senha" required>
			</div>
			<div class="input-field">
				<input type="password" id="senha-confirm" name="senha-confirm" placeholder="Confirme sua senha" required>
			</div>
            <button type="submit" class="button">Redefinir Senha</button>
            <div id="errorMessage" class="error-message"></div>
        </form>
    </div>
    <script>
        document.getElementById("resetForm").addEventListener("submit", function(event) {
            // Obtém os valores dos campos de senha
            const novaSenha = document.getElementById("senha").value;
            const confirmarSenha = document.getElementById("senha-confirm").value;
            const errorMessage = document.getElementById("errorMessage");

            // Limpa a mensagem de erro
            errorMessage.textContent = "";

            // Verifica se as senhas coincidem
            if (novaSenha !== confirmarSenha) {
                // Mostra mensagem de erro e impede o envio do formulário
                errorMessage.textContent = "As senhas não coincidem. Por favor, tente novamente.";
                event.preventDefault();
            }
        });
    </script>
</body>
</html>
