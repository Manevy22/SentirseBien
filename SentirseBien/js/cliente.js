document.addEventListener('DOMContentLoaded', function() {
    const authToken = localStorage.getItem('authToken');
    const clienteId = localStorage.getItem('clienteId'); // Recupera el ID del cliente

    if (!authToken || !clienteId) {
        // Redirigir al login si no hay token o ID
        window.location.href = 'login.html';
        return;
    }

    async function loadClientProfile() {
        try {
            const response = await fetch(`http://localhost:8081/cliente/perfil?clienteId=${clienteId}`, {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${authToken}`
                }
            });

            if (response.ok) {
                const data = await response.json();
                displayProfile(data);
            } else {
                console.error('Error al cargar perfil:', response.statusText);
            }
        } catch (error) {
            console.error('Error al conectarse al servidor:', error);
        }
    }

    function displayProfile(profile) {
        // Actualizar las sesiones
        const sessionsBody = document.querySelector('.lessons tbody');
        sessionsBody.innerHTML = profile.lista_Sesiones.map(session => `
            <tr>
                <td>${session.servicio}</td>
                <td>${new Date(session.fecha).toLocaleDateString()}</td>
                <td>$${session.costo.toFixed(2)}</td>
                <td>${session.asistencia ? 'Finalizado' : 'Pendiente'}</td>
            </tr>
        `).join('');

        // Actualizar la información del cliente
        const profileName = document.querySelector('.profile-info h3');
        profileName.textContent = `${profile.nombre} ${profile.apellido}`;

        // Actualizar el ID del cliente en el botón
        const clientIdButton = document.querySelector('.profile-info button');
        clientIdButton.textContent = `ID Cliente: ${profile.id}`;

        // Actualizar la imagen de perfil si está disponible
        const profilePicture = document.querySelector('.profile-picture img');
        if (profile.imagenPerfil) {
            profilePicture.src = profile.imagenPerfil;
        }
    }

    // Cargar el perfil al iniciar
    loadClientProfile();
});
