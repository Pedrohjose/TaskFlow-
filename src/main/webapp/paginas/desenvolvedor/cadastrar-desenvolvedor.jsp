<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Usuário</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/resources/estilos/style.css">
</head>
<body>
    <div class="container">
        <h2>Cadastro de Usuário</h2>
        <form action="inserir-desenvolvedor" method="post">
            <label for="nome">Nome do Usuário:</label>
            <input type="text" id="nome" name="nome" required>

            <label for="email">E-mail:</label>
            <input type="email" id="email" name="email" required>

            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required>

            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" required maxlength="14" placeholder="000.000.000-00">

            <label for="funcao">Função:</label>
            <select id="funcao" name="funcao" required>
                <option value="BACK_END">Back-End</option>
                <option value="FRONT_END">Front-End</option>
                <option value="BANCO_DE_DADOS">Banco de Dados</option>
                <option value="FULL_STACK">Full Stack</option>
            </select>

            <button type="submit">Cadastrar</button>
        </form>
    </div>
</body>
</html>
