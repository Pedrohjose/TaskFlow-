<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro - MindFlow</title>
    <link rel="stylesheet" href="../css/autenticacao.css">
</head>
<body>
    <div class="pagina">
        <form method="POST" class="formularioCadastro">
            <h1>Cadastro</h1>
            <p>Preencha os campos abaixo para criar uma conta.</p>
            <label for="nome">Nome</label>
            <input type="text" placeholder="Digite seu nome" autofocus="true" />
            <label for="email">E-mail</label>
            <input type="email" placeholder="Digite seu e-mail" />
            <label for="senha">Senha</label>
            <input type="password" placeholder="Digite sua senha" />
            <label for="confirmarSenha">Confirmar Senha</label>
            <input type="password" placeholder="Confirme sua senha" />
            <input type="submit" value="Cadastrar" class="botao" />
            <button type="button" class="alternar" onclick="window.location.href='login.jsp'">Já tem uma conta? Faça login</button>
        </form>
    </div>
</body>
</html>