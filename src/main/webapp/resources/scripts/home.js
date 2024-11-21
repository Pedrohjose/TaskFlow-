function scrollToElement(elementSelector, instance = 0) {
	// Select all elements that match the given selector
	const elements = document.querySelectorAll(elementSelector);
	// Check if there are elements matching the selector and if the requested instance exists
	if (elements.length > instance) {
		// Scroll to the specified instance of the element
		elements[instance].scrollIntoView({ behavior: 'smooth' });
	}
}

function openCriarTarefa() {
	const modal = document.getElementById("modal");
	modal.style.display = "flex";

	// Carrega conteúdo externo
	fetch("paginas/tarefa/criar-tarefa.jsp") // Substitua por uma URL válida para teste
		.then(response => response.text())
		.then(data => {
			document.getElementById("modal-body").innerHTML = data;
		})
		.catch(error => {
			document.getElementById("modal-body").innerHTML = "Erro ao carregar conteúdo.";
			console.error("Erro:", error);
		});
}

// Função para fechar o modal
function closeModal(event) {
	if (event.target === document.getElementById("modal")) {
		document.getElementById("modal").style.display = "none";
	}
}

const link1 = document.getElementById("link1");
const link2 = document.getElementById("link2");
const link3 = document.getElementById("link3");

link1.addEventListener('click', () => {
	scrollToElement('.header');
});

link2.addEventListener('click', () => {
	// Scroll to the second element with "header" class
	scrollToElement('.header', 1);
});

link3.addEventListener('click', () => {
	scrollToElement('.column');
});



function openEditarTarefa(idTipoTarefa) {
	const modal = document.getElementById("modal");
	modal.style.display = "flex";

	// Carrega conteúdo externo
	fetch(`paginas/tarefa/editarTarefa.jsp?idTipoTarefa=${idTipoTarefa}`) // Substitua por uma URL válida para teste
		.then(response => response.text())
		.then(data => {
			document.getElementById("modal-body").innerHTML = data;
		})
		.catch(error => {
			document.getElementById("modal-body").innerHTML = "Erro ao carregar conteúdo.";
			console.error("Erro:", error);
		});
}