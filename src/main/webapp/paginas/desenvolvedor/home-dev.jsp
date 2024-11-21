<%@page import="modelo.enumeracao.status.Status"%>
<%@page import="modelo.entidade.tarefa.Tarefa"%>
<%@page import="modelo.dao.tarefa.TarefaDAOImpl"%>
<%@page import="modelo.dao.tipotarefa.TipoTarefaDAOImpl"%>
<%@page import="modelo.entidade.tipotarefa.TipoTarefa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/remixicon/3.5.0/remixicon.min.css">
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/resources/estilos/home.css">
<title>SoftLeve</title>
</head>

<body>

	<nav>
    <div class="nav-logo">
        <img src="<%=request.getContextPath() %>/resources/imagens/home/logohome1.png" class="logo-img" alt="Logotipo SoftLeve">
    </div>

    <ul class="nav-links">
        <li id="link1" class="link"><a href="#">Tarefas</a></li>
    </ul>
    <form action="<%=request.getContextPath() %>/logout" method="POST">
       <button class="btn logout-btn" onclick="window.location.href='<%= request.getContextPath() %>/logout'">
    <i class="ri-logout-box-line"></i> Logout
</button>
    </form>
</nav>

	<header class="container">
	<div class="image">
			<img
				src="<%=request.getContextPath() %>/resources/imagens/home/header.png">
		</div>
		<div class="content">
			<h4>Bem Vindo</h4>
			<H1>
				Gestão de <span>Tarefas</span> com a <u>SoftLeve</u>
			</H1>
			<p>SoftLeve é uma empresa especializada no desenvolvimento de soluções inovadoras em software de gestão de tarefas. Oferecemos ferramentas inteligentes e intuitivas que simplificam processos, otimizam o tempo e aumentam a produtividade das equipes. Com foco em eficiência e personalização, ajudamos empresas de diversos segmentos a alcançar seus objetivos com organização e praticidade.</p>
		</div>
	</header>

	<section class="container">
        <!-- Título para a listagem de tarefas -->
        <h2 class="header">
            Listagem das Tarefas
        </h2>

        <!-- Contêiner para centralizar o botão de adicionar -->
        <div class="section-btn-container">
            <!-- Botão para adicionar tarefa -->
            <button class="add-task-btn" onclick="openCriarTarefa()">Adicionar Tarefa</button>
        </div>

        <!-- Tarefas -->
        <div class="features">
            <%
                TipoTarefaDAOImpl tipoTarefaDAO = new TipoTarefaDAOImpl();
                TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();
                for(TipoTarefa tipoTarefa : tipoTarefaDAO.recuperarTipoTarefas()){
                    Tarefa tarefa = tarefaDAO.recuperarTarefaPorIdUsaurio(tipoTarefa.getTarefa().getIdTarefa());
            %>
            <div class="card" onclick="openEditarTarefa(<%= tipoTarefa.getIdTipoTarefa() %>)">
                <% if(tarefa.getStatus() == Status.valueOf("PENDENTE")){ %>
                <span style="background-color: red;"><i class="ri-close-circle-line"></i></span>
                <% } %>
                <% if(tarefa.getStatus() == Status.valueOf("CONCLUIDO")){ %>
                <span style="background-color: green;"><i class="ri-checkbox-circle-line"></i></span>
                <% } %>
                <% if(tarefa.getStatus() == Status.valueOf("EM_ANDAMENTO")){ %>
                <span style="background-color: rgb(206, 171, 18);"><i class="ri-history-line"></i></span>
                <% } %>
                <h4><%=tarefa.getNomeTarefa() %></h4>
                <p><%=tarefa.getDescricao() %></p>

                <!-- Botão de excluir tarefa fora do card, mas ainda dentro da estrutura da tarefa -->
                <% if(tarefa.getStatus() != Status.valueOf("CONCLUIDO")){ %>
                <form action="deletar-tarefa">
                    <button type="submit" class="delete-task-btn">
                        <input type="hidden" value="<%=tipoTarefa.getIdTipoTarefa()%>" name="idTipoTarefa">
                        <input type="hidden" value="<%=tarefa.getIdTarefa()%>" name="idTarefa">
                        Deletar <i class="ri-delete-bin-6-line"></i>
                    </button>
                </form>
                <% } %>
            </div>
            <% } %>
        </div>
    </section>

    <div id="modal" class="modal-overlay" onclick="closeModal(event)">
        <div class="modal-content" onclick="event.stopPropagation()">
            <div id="modal-body"></div>
        </div>
    </div>

<footer class="container">
    <span class="blur"></span> <span class="blur"></span>
    <div class="column">
        <div class="logo">
            <img src="<%=request.getContextPath() %>/resources/imagens/home/logohome1.png">
        </div>
        <p>Bem-vindo à TaskFlow, a plataforma ideal para gerenciamento de tarefas e produtividade.</p>
        <div class="socials">
            <a href="#"><i class="ri-youtube-line"></i></a> 
            <a href="#"><i class="ri-instagram-line"></i></a> 
            <a href="#"><i class="ri-twitter-line"></i></a>
        </div>
    </div>
    <div class="column">
        <h4>Empresa</h4>
        <a href="#">Negócios</a> <a href="#">Parcerias</a> <a href="#">Rede</a>
    </div>
    <div class="column">
        <h4>Sobre Nós</h4>
        <a href="#">Blogs</a> <a href="#">Canais</a> <a href="#">Patrocinadores</a>
    </div>
    <div class="column">
        <h4>Contato</h4>
        <a href="#">Fale Conosco</a> <a href="#">Política de Privacidade</a> <a href="#">Termos & Condições</a>
    </div>
</footer>

<div class="copyright">Copyright © 2023 TaskFlow. Todos os direitos reservados.</div>

<script src="<%=request.getContextPath()%>/resources/scripts/home.js"></script>
</body>

</html>