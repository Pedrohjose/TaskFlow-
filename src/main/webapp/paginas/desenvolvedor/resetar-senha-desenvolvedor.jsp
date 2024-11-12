<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resetar Senha</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
        }
        .reset-container {
            width: 300px;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }
        .reset-container h2 {
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        .form-group label {
            display: block;
            font-size: 14px;
            color: #555;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn-reset {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-reset:hover {
            background-color: #45a049;
        }
        .error-message {
            color: #e74c3c;
            font-size: 14px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="reset-container">
        <h2>Resetar Senha</h2>
        <form id="resetForm" action="desbloquear-usuario" method="post">
            <div class="form-group">
                <label for="novaSenha">Nova Senha:</label>
                <input type="password" id="novaSenha" name="novaSenha" required>
            </div>
            <div class="form-group">
                <label for="confirmarSenha">Confirmar Senha:</label>
                <input type="password" id="confirmarSenha" name="confirmarSenha" required>
            </div>
            <button type="submit" class="btn-reset">Redefinir Senha</button>
            <div id="errorMessage" class="error-message"></div>
        </form>
    </div>
    <script>
        document.getElementById("resetForm").addEventListener("submit", function(event) {
            // Obtém os valores dos campos de senha
            const novaSenha = document.getElementById("novaSenha").value;
            const confirmarSenha = document.getElementById("confirmarSenha").value;
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
