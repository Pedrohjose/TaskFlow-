document.getElementById("form-cadastro").addEventListener("submit", function(event) {
    const senha = document.getElementById('senha').value;
    const senhaConfirmada = document.getElementById('senha-confirm').value;
    const campoSenhaConfirm = document.getElementById('senha-confirm');

    if (senha !== senhaConfirmada) {
        event.preventDefault();
        campoSenhaConfirm.style.border = '1px solid red';  
        campoSenhaConfirm.focus();
        campoSenhaConfirm.addEventListener('focus', () => {
            campoSenhaConfirm.style.border = '';  
        });
    }
});