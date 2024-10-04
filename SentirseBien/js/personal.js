document.addEventListener('DOMContentLoaded', function() {
    const authToken = localStorage.getItem('authToken');
    const personalId = localStorage.getItem('personalId'); // Recupera el ID del personal

    if (!authToken || !personalId) {
        // Redirigir al login si no hay token o ID
        window.location.href = 'login.html';
        return;
    }

    async function loadPersonalProfile() {
        try {
            const response = await fetch(`https://overflowing-magic-production.up.railway.app/personal/perfil?PersonalId=${personalId}`, {
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
        const nombreUsuarioElement = document.getElementById('nombreUsuario');
        if (nombreUsuarioElement) {
        nombreUsuarioElement.textContent = profile.nombre_usuario;
        }
    const sessionsBody = document.querySelector('.lessons tbody');
    sessionsBody.innerHTML = profile.listaPer_Ses.map(session => {
        // Convertir la fecha al objeto Date en UTC
        const date = new Date(session.fecha);
        // Convertir a la fecha local en la zona horaria del navegador
        const localDate = date.toLocaleDateString('es-ES', {
            timeZone: 'UTC',
            year: 'numeric',
            month: '2-digit',
            day: '2-digit'
        });
        return `
            <tr data-id="${session.idCliente}">
                <td>${session.idCliente}</td>
                <td>${session.nombreCliente}</td>
                <td>${session.servicio}</td>
                <td>${localDate}</td>
                <td>$${session.costo.toFixed(2)}</td>
                <td>${session.asistencia ? 'Finalizado' : 'Pendiente'}</td>
            </tr>
        `;
    }).join('');
}


    // Filtrar las sesiones en la tabla según el ID del cliente
    document.getElementById('searchInput').addEventListener('input', function(event) {
        const searchTerm = event.target.value.toLowerCase();
        const rows = document.querySelectorAll('.lessons tbody tr');

        rows.forEach(row => {
            const clientId = row.dataset.id.toLowerCase();
            if (clientId.includes(searchTerm)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });

    // Cargar el perfil al iniciar
    loadPersonalProfile();
});
