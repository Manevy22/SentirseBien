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
                    endpoint = 'https://overflowing-magic-production.up.railway.app/Cliente/login';
                } else if (role === 'Personal') {
                    endpoint = 'https://overflowing-magic-production.up.railway.app/Personal/login';
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
   
      // Función para obtener el perfil del personal
    async function getPerfilPersonal(personalId) {
        try {
            const response = await fetch(`https://overflowing-magic-production.up.railway.app/personal/perfil?PersonalId=${personalId}`, {
                method: 'GET',
                credentials: 'include' // Si es necesario
            });

            const data = await response.json();

            if (response.ok) {
                // Actualizar el nombre de usuario en el HTML
                document.getElementById('nombreUsuario').textContent = data.nombre_usuario;
            } else {
                console.error('Error al obtener el perfil:', data);
                document.getElementById('nombreUsuario').textContent = 'Usuario no encontrado';
            }
        } catch (error) {
            console.error('Error:', error);
            document.getElementById('nombreUsuario').textContent = 'Error al obtener perfil';
        }
    }
});

