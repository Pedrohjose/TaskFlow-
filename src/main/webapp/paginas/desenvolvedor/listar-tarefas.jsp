<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Tarefas</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .button-container {
            margin-bottom: 20px;
            text-align: center;
        }
        .button {
            padding: 10px 20px;
            color: #fff;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Lista de Tarefas</h2>
    <div class="button-container">
        <a href="cadastrar-tarefa" class="button">Cadastrar Nova Tarefa</a>
    </div>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Status</th>
            <th>Data de Criação</th>
            <th>Data de Prazo</th>
            <th>Data de Conclusão</th>
        </tr>
        <c:forEach var="tarefa" items="${listaTarefas}">
            <tr>
                <td>${tarefa.idTarefa}</td>
                <td>${tarefa.nomeTarefa}</td>
                <td>${tarefa.descricao}</td>
                <td>${tarefa.status}</td>
                <td>${tarefa.dataCriacao}</td>
                <td>${tarefa.dataPrazo}</td>
                <td>
                    <c:choose>
                        <c:when test="${tarefa.dataConclusao != null}">
                            ${tarefa.dataConclusao}
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
