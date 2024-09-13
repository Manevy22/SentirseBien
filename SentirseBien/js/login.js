document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loginForm');
    const errorMessage = document.getElementById('error-message');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        // Obtener valores del formulario
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const roleElement = document.querySelector('input[name="role"]:checked');

        if (roleElement) {
            const role = roleElement.value;
            try {
                let endpoint = '';
                if (role === 'Cliente') {
                    endpoint = 'http://localhost:8081/Cliente/login';
                } else if (role === 'Personal') {
                    endpoint = 'http://localhost:8081/Personal/login';
                }

                if (!endpoint) {
                    throw new Error('Rol no válido');
                }

                // Enviar datos al servidor
                const response = await fetch(endpoint, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        username: username,
                        password: password
                    })
                });

                const data = await response.json();

                if (data.success) {
                    // Guardar token y ID en localStorage
                    localStorage.setItem('authToken', data.token);

                    if (role === 'Cliente') {
                        localStorage.setItem('clienteId', data.clienteId);
                        window.location.href = 'cliente.html';
                    } else if (role === 'Personal') {
                        localStorage.setItem('personalId', data.personalId);
                        window.location.href = 'personal.html';
                    }

                    localStorage.setItem('userRole', role); // Guardar rol en localStorage
                } else {
                    // Mostrar mensaje de error si el login falla
                    errorMessage.textContent = data.message || 'Nombre de usuario o contraseña incorrectos.';
                }
            } catch (error) {
                // Manejo de errores al conectar con el servidor
                errorMessage.textContent = 'Error al conectarse al servidor. Inténtelo más tarde.';
            }
        } else {
            // Mostrar mensaje de error si no se ha seleccionado ningún rol
            errorMessage.textContent = 'Debe seleccionar un rol.';
        }
    });
});
