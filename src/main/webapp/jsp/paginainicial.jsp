<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Inicial - MindFlow</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Marcellus&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/paginaInicial.css">
</head>
<body>
    <div class="container">
        <!-- Sidebar -->
        <jsp:include page="sidebar.jsp" />
s
        <!-- Main Content -->
        <main class="main-content">
            <jsp:include page="header.jsp" />

            <section class="recommended-events">
                <h2>Recommended Events</h2>
                <div class="event">
                    <img src="https://via.placeholder.com/300x150" alt="Event Image">
                    <div class="event-info">
                        <h3>GLADIATOR VS KNIGHTS</h3>
                        <p>Group Stage</p>
                    </div>
                </div>
            </section>

            <section class="news-archive">
                <h2>News Archive</h2>
                <div class="news-item">
                    <img src="https://via.placeholder.com/150x200" alt="News Image">
                    <div class="news-info">
                        <h3>Historical Games</h3>
                        <p>Warring factions have brought the Origin System to the brink of destruction.</p>
                        <a href="#">View More</a>
                    </div>
                </div>
            </section>
        </main>
    </div>
</body>
</html>
