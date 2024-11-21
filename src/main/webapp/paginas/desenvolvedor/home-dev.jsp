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
			<a
				href="<%=request.getContextPath()%>/paginas/desenvolvedor/home-dev.jsp">
				<img
				src="<%=request.getContextPath() %>/resources/imagens/home/logohome1.png" class="logo-img" alt="Logotipo SoftLeve">
			</a>
		</div>

		<ul class="nav-links">
			<li id="link1" class="link"><a href="#">Tarefas</a></li>
			<li id="link2" class="link"><a href="#">Perfil</a></li>
		</ul>
		<button class="btn">Hire Me</button>
	</nav>

	<header class="container">
		<div class="content">
			<span class="blur"></span> <span class="blur"></span>
			<h4>Bem Vindo</h4>
			<H1>
				Gereciador de <span>Tarefas</span>, SoftLeve
			</H1>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
				Earum, ipsum, nisi quas vero culpa reprehenderit itaque quos optio
				at maiores consequuntur. A sequi cumque facere quis hic nam, officia
				ratione.</p>
		</div>
		<div class="image">
			<img
				src="<%=request.getContextPath() %>/resources/imagens/home/header.png">
		</div>
	</header>

	<section class="container">

		<h2 class="header">
			<button type="button" onclick="openCriarTarefa()">Tarefa</button>
		</h2>

		<div class="features">
			<%
        		TipoTarefaDAOImpl tipoTarefaDAO = new TipoTarefaDAOImpl();
        		TarefaDAOImpl tarefaDAO = new TarefaDAOImpl();
        		for(TipoTarefa tipoTarefa : tipoTarefaDAO.recuperarTipoTarefas()){
        			
        			Tarefa tarefa = tarefaDAO.recuperarTarefaPorIdUsaurio(tipoTarefa.getTarefa().getIdTarefa());
        	%>
			<div class="card"
				onclick="openEditarTarefa(<%= tipoTarefa.getIdTipoTarefa() %>)">
				<% 
        	                    	if(tarefa.getStatus() == Status.valueOf("PENDENTE")){
        	        %>
				<span style="background-color: red;"><i
					class="ri-close-circle-line"></i></span>
				<%
        	                    	}
        	        %>
				<% 
        	                    	if(tarefa.getStatus() == Status.valueOf("CONCLUIDO")){
        	        %>
				<span style="background-color: green;"><i
					class="ri-checkbox-circle-line"></i></span>
				<%
        	                    	}
        	        %>
				<% 
        	                    	if(tarefa.getStatus() == Status.valueOf("EM_ANDAMENTO")){
        	        %>
				<span style="background-color: rgb(206, 171, 18);"><i
					class="ri-history-line"></i></span>
				<%
        	                    	}
        	        %>
				<h4><%=tarefa.getNomeTarefa() %></h4>
				<p>
					<%=tarefa.getDescricao() %>
				</p>
				<%
						if(tarefa.getStatus() == Status.valueOf("CONCLUIDO")){
							
							%>

				<form action="gerar-relatorio" method="post">
					<button type="submit">
						<input type="hidden" value="<%=tipoTarefa.getIdTipoTarefa()%>"
							name="idTipoTarefa"></input> <input type="hidden"
							value="<%=tarefa.getIdTarefa()%>" name="idTarefa"></input> <a
							href="#">Relatorio <i class="ri-arrow-right-line"></i></a>
					</button>
				</form>

				<%
						}else{
							%>
				<form action="deletar-tarefa">
					<button type="submit">
						<input type="hidden" value="<%=tipoTarefa.getIdTipoTarefa()%>"
							name="idTipoTarefa"></input> <input type="hidden"
							value="<%=tarefa.getIdTarefa()%>" name="idTarefa"></input> <a
							href="#">Deletar <i class="ri-arrow-right-line"></i></a>
					</button>
				</form>

				<%
						}
					
					%>
			</div>
			<%
        		}
        	%>
		</div>
	</section>x
	<div id="modal" class="modal-overlay" onclick="closeModal(event)">
		<div class="modal-content" onclick="event.stopPropagation()">
			<div id="modal-body"></div>
		</div>
	</div>
	<footer class="container">
		<span class="blur"></span> <span class="blur"></span>
		<div class="column">
			<div class="logo">
				<img
					src="<%=request.getContextPath() %>/resources/imagens/home/logo.png">
			</div>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.</p>
			<div class="socials">
				<a href="#"><i class="ri-youtube-line"></i></a> <a href="#"><i
					class="ri-instagram-line"></i></a> <a href="#"><i
					class="ri-twitter-line"></i></a>
			</div>
		</div>
		<div class="column">
			<h4>Company</h4>
			<a href="#">Business</a> <a href="#">Partnership</a> <a href="#">Network</a>
		</div>
		<div class="column">
			<h4>About Us</h4>
			<a href="#">Blogs</a> <a href="#">Channels</a> <a href="#">Sponsors</a>
		</div>
		<div class="column">
			<h4>Contact</h4>
			<a href="#">Contact Us</a> <a href="#">Privicy Policy</a> <a href="#">Terms
				& Conditions</a>
		</div>
	</footer>

	<div class="copyright">Copyright © 2023 AsmrProg Channel. All
		Rights Reserved.</div>


	<script src="<%=request.getContextPath()%>/resources/scripts/home.js"></script>
</body>

</html>