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
        const sessionsBody = document.querySelector('.lessons tbody');
        sessionsBody.innerHTML = profile.listaPer_Ses.map(session => `
            <tr data-id="${session.idCliente}">
                <td>${session.idCliente}</td>
                <td>${session.nombreCliente}</td>
                <td>${session.servicio}</td>
                <td>${new Date(session.fecha).toLocaleDateString()}</td>
                <td>$${session.costo.toFixed(2)}</td>
                <td>${session.asistencia ? 'Finalizado' : 'Pendiente'}</td>
            </tr>
        `).join('');
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
