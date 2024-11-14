<!DOCTYPE html>
<html>
<head>
    <title>Cadastrar Tarefa</title>
</head>
<body>
    <h2>Nova Tarefa</h2>
    <form action="inserir-tarefa" method="post">
        <label for="nome">Nome da Tarefa:</label>
        <input type="text" id="nome" name="nome" required><br><br>

        <label for="descricao">Descrição:</label>
        <textarea id="descricao" name="descricao" required></textarea><br><br>

        <label for="dataPrazo">Data de Prazo:</label>
        <input type="date" id="dataPrazo" name="dataPrazo" required><br><br>

        <label for="status">Status:</label>
        <select id="status" name="status">
            <option value="PENDENTE">Pendente</option>
            <option value="EM_PROGRESSO">Em Progresso</option>
            <option value="CONCLUIDA">Concluída</option>
            <option value="CANCELADA">Cancelada</option>
        </select><br><br>

        <input type="submit" value="Cadastrar Tarefa">
    </form>
</body>
</html>
