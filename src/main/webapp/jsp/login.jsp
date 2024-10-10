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
        <form method="POST" class="formularioLogin">
            <h1>Log-in</h1>
            <p>Preencha os campos abaixo para entrar em uma conta.</p>
            <label for="email">E-mail</label>
            <input type="email" placeholder="Digite seu e-mail" />
            <label for="senha">Senha</label>
            <input type="password" placeholder="Digite sua senha" />
            <input type="submit" value="Cadastrar" class="botao" />
            <button type="button" class="alternar" onclick="window.location.href='cadastro-usuario.jsp'">Não tem uma conta? Faça Cadastro</button>
        </form>
    </div>
</body>
</html>