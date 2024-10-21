<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <meta charset="UTF-8" />
    <link
      rel="shortcut icon"
      href="${pageContext.request.contextPath}/img/favicon.ico"
      type="image/x-icon"
    />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" media="all" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
      rel="stylesheet"
    />
    <title>Sign up | TaskFlow</title>
    <meta name="author" content="Enzo dos Santos Scholl" />
    <meta
      name="description"
      content="Empresa fictícia que trabalha com gerenciamento de tarefas"
    />
    <meta name="keywords" content="css, html, java, js, sql, taskflow" />
  </head>
  <body>
    <div class="main-content">
      <!-- Registro -->
      <div class="register-section">
        <h1 aria-label="Sign up">Sign up</h1>
        <form action="${pageContext.request.contextPath}/usuario" method="post">
          <input type="hidden" name="action" value="cadastrar" />
          <div class="form-group">
            <label for="username" aria-label="Usuário"
              >Usuário <span class="required">*</span></label
            >
            <input
              type="text"
              name="username"
              id="username"
              maxlength="100"
              autocomplete="username"
              required
              aria-label="Campo para registrar seu usuário"
            />
          </div>
          <div class="form-group">
            <label for="password" aria-label="Senha"
              >Senha <span class="required">*</span></label
            >
            <div class="input-group">
              <input
                type="password"
                name="password"
                id="password"
                maxlength="100"
                autocomplete="new-password"
                required
                aria-label="Campo para registrar sua senha"
              />
              <span class="show-password" role="button"
                ><img
                  src="${pageContext.request.contextPath}/img/register/eye.svg"
                  alt="Botão para visualizar a senha"
              /></span>
            </div>
          </div>
          <div class="form-group">
            <label for="confirm-password" aria-label="Confirmar senha"
              >Confirmar senha <span class="required">*</span></label
            >
            <input
              type="password"
              name="confirm-password"
              id="confirm-password"
              maxlength="100"
              autocomplete="new-password"
              required
              aria-label="Campo para confirmar sua senha"
            />
            <span
              class="validation-error"
              aria-label="Senhas não correspondem"
              role="alert"
              aria-hidden="true"
              >Senhas não correspondem</span
            >
          </div>
          <div id="dev-group" class="form-group">
            <input
              type="checkbox"
              name="is-dev"
              id="is-dev"
              aria-label="Campo para confirmar seu papel"
            />
            <label for="is-dev" aria-label="Sou um desenvolvedor"
              >Sou um desenvolvedor</label
            >
          </div>
          <button
            type="submit"
            aria-label="Botão para enviar informações do formulário"
          >
            Sign up
          </button>
        </form>
        <span aria-label="Seção de redirecionamento para logar numa conta"
          >Já possui uma conta? <a href="${pageContext.request.contextPath}/login.jsp">Login!</a></span
        >
      </div>
      <!-- Slides -->
      <div class="slides-section">
        <img
          src="${pageContext.request.contextPath}/img/register/showcase.svg"
          alt="Imagem demonstrativa"
        />
        <h2 aria-label="Mantenha suas atividades sempre em ordem!">
          Mantenha suas atividades sempre em ordem!
        </h2>
        <p
          aria-label="A TaskFlow permite que você crie, organize e priorize suas tarefas de forma intuitiva, garantindo que nada fique fora do lugar. Acompanhe deadlines e mantenha o foco no que é mais importante."
        >
          A TaskFlow permite que você crie, organize e priorize suas tarefas de
          forma intuitiva, garantindo que nada fique fora do lugar. Acompanhe
          deadlines e mantenha o foco no que é mais importante.
        </p>
        <div class="slides-controls">
          <span
            class="slide-button current"
            aria-label="Botão para passar slide"
            role="button"
            data-slide="1"
          ></span>
          <span
            class="slide-button"
            aria-label="Botão para passar slide"
            role="button"
            data-slide="2"
          ></span>
          <span
            class="slide-button"
            aria-label="Botão para passar slide"
            role="button"
            data-slide="3"
          ></span>
        </div>
      </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/main.js" defer></script>
  </body>
</html>
