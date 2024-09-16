// Selecciona el formulario por ID
document.querySelector('#formulario-registro').addEventListener('submit', function (event) {
    event.preventDefault(); // Evita el envío normal del formulario

    // Verifica si las contraseñas coinciden
    if (!validatePasswords()) {
        return;
    }

    // Crea un objeto con los datos del formulario
    const formData = {
        id: 0,
        nombre: document.querySelector('input[name="nombre"]').value,
        apellido: document.querySelector('input[name="apellido"]').value,
        correo: document.querySelector('input[name="email"]').value,
        contrasenia: document.getElementById('password').value,
        nombre_usuario: document.querySelector('input[name="nombreUsuario"]').value,
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
    fetch('https://overflowing-magic-production.up.railway.app/clientes/crear', requestOptions)
    .then(response => {
        if (response.status === 201) {
            return response.json().then(data => {
                alert('Usuario creado exitosamente.');
                // Redirige al usuario a la página de inicio de sesión
                window.location.href = 'Login.html';
            });
        } else {
            return response.text().then(message => {
                alert('Cliente creado: ' + message);
                // Redirige al usuario a la página de inicio de sesión en caso de error
                window.location.href = 'Login.html';
            });
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Cliente creado');
        // Redirige al usuario a la página de inicio de sesión en caso de error
        window.location.href = 'Login.html';
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

