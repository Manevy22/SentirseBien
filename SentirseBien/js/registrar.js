// Selecciona el formulario y agrega un evento de envío
document.querySelector('form').addEventListener('submit', function (event) {
    event.preventDefault(); // Evita el envío normal del formulario

    // Verifica si las contraseñas coinciden
    if (!validatePasswords()) {
        return;
    }

    // Crea un objeto con los datos del formulario
    const formData = {
        id:0,
        nombre: document.querySelector('input[placeholder="Nombre"]').value,
        apellido: document.querySelector('input[placeholder="Apellido"]').value,
        correo: document.querySelector('input[placeholder="Email"]').value,
        contrasenia: document.getElementById('password').value,
        nombre_usuario: document.querySelector('input[placeholder="Nombre de Usuario"]').value,
        listaSesiones: [],   
        listaConsultas: [],  
        listaServicio: []
    };

    // Configura los detalles de la petición
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData)
    };

    // Realiza la petición POST a la API
    fetch('http://localhost:8081/clientes/crear', requestOptions)
    .then(response => {
        if (response.status === 201) {
            return response.json().then(data => alert('Usuario creado exitosamente.'));
        } else if (response.status === 409) {
            return response.text().then(message => alert('Error: ' + message));
        } else {
            return response.text().then(message => alert('Hubo un problema: ' + message));
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Hubo un problema al crear el usuario.');
    });

});

// Función para validar las contraseñas
function validatePasswords() {
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (password !== confirmPassword) {
        alert('Las contraseñas no coinciden.');
        return false;
    }
    return true;
}
