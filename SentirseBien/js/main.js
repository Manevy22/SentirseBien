document.addEventListener('DOMContentLoaded', function() {
    // Obtener elementos del DOM
    const prevBtn = document.querySelector('.carousel-control.prev');
    const nextBtn = document.querySelector('.carousel-control.next');
    const container = document.querySelector('.classes-container');
    const searchIcon = document.getElementById('searchIcon');
    const searchInput = document.getElementById('searchInput');
    const searchContainer = document.querySelector('.search-container');
    
    // Verificar que los elementos existen antes de agregar los event listeners
    if (prevBtn && nextBtn && container) {
        prevBtn.addEventListener('click', function() {
            container.scrollBy({ left: -container.clientWidth / 3, behavior: 'smooth' });
        });

        nextBtn.addEventListener('click', function() {
            container.scrollBy({ left: container.clientWidth / 3, behavior: 'smooth' });
        });
    } else {
        console.error('Elementos prevBtn, nextBtn o container no encontrados en el DOM.');
    }

    // Agregar event listener para el ícono de búsqueda
    if (searchIcon && searchInput && searchContainer) {
        searchIcon.addEventListener('click', function() {
            searchContainer.classList.toggle('active');
            searchInput.focus();
        });

        // Ocultar el campo de búsqueda al hacer clic fuera del contenedor de búsqueda
        document.addEventListener('click', function(event) {
            if (!searchContainer.contains(event.target) && searchContainer.classList.contains('active')) {
                searchContainer.classList.remove('active');
            }
        });
    } else {
        console.error('Elementos searchIcon, searchInput o searchContainer no encontrados en el DOM.');
    }
    
    // Código relacionado con el calendario
    const calendarBody = document.querySelector('.days');
    const currentDate = document.querySelector('.current-date');
    const prevNextIcon = document.querySelectorAll('.icons span');

    if (calendarBody && currentDate && prevNextIcon.length > 0) {
        // Renderizar calendario y agregar eventos de navegación
        renderCalendar();

        prevNextIcon.forEach(icon => {
            icon.addEventListener("click", () => {
                currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;

                if(currMonth < 0 || currMonth > 11) {
                    date = new Date(currYear, currMonth);
                    currYear = date.getFullYear();
                    currMonth = date.getMonth();
                } else {
                    date = new Date();
                }
                renderCalendar();
            });
        });
    } else {
        console.error('Elementos del calendario no encontrados en el DOM.');
    }
});

function renderCalendar() {
    // Lógica para renderizar el calendario
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay();
    let lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate();
    let lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay();
    let lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate();

    let liTag = "";

    // Crear las fechas del mes anterior
    for (let i = firstDayofMonth; i > 0; i--) {
        liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
    }

    // Crear las fechas del mes actual
    for (let i = 1; i <= lastDateofMonth; i++) {
        let isToday = i === date.getDate() && currMonth === new Date().getMonth()
                      && currYear === new Date().getFullYear() ? "active" : "";
        liTag += `<li class="${isToday}">${i}</li>`;
    }

    // Crear las fechas del mes siguiente
    for (let i = lastDayofMonth; i < 6; i++) {
        liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`
    }

    // Actualizar el DOM
    if (currentDate && calendarBody) {
        //currentDate.innerText = `${months[currMonth]} ${currYear}`;
        //calendarBody.innerHTML = liTag;
    }
}
