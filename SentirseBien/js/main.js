document.addEventListener('DOMContentLoaded', function() {
    const prevBtn = document.querySelector('.carousel-control.prev');
    const nextBtn = document.querySelector('.carousel-control.next');
    const container = document.querySelector('.classes-container');

    prevBtn.addEventListener('click', function() {
        container.scrollBy({ left: -container.clientWidth / 3, behavior: 'smooth' });
    });

    nextBtn.addEventListener('click', function() {
        container.scrollBy({ left: container.clientWidth / 3, behavior: 'smooth' });
    });
});

//redireccion al chat al cliente cuando preciona el boton de enviar  
function focusChat() {
    document.getElementById('message-input').focus();
}



const calendarBody = document.querySelector('.days');
const currentDate = document.querySelector('.current-date');
const prevNextIcon = document.querySelectorAll('.icons span');

// Obtener la fecha actual
let date = new Date();
let currYear = date.getFullYear();
let currMonth = date.getMonth();

// Lista de nombres de meses
const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

// Función para renderizar el calendario
function renderCalendar() {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(); // Primer día del mes
    let lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(); // Última fecha del mes
    let lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(); // Último día del mes
    let lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); // Última fecha del mes anterior

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
    currentDate.innerText = `${months[currMonth]} ${currYear}`;
    calendarBody.innerHTML = liTag;
}

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
document.addEventListener('DOMContentLoaded', function() {
    var searchIcon = document.getElementById('searchIcon');
    var searchInput = document.getElementById('searchInput');
    var searchContainer = document.querySelector('.search-container');
    
    // Muestra el campo de búsqueda al hacer clic en el ícono
    searchIcon.addEventListener('click', function() {
        searchContainer.classList.toggle('active');
        searchInput.focus();
    });
    
    // Oculta el campo de búsqueda al hacer clic fuera del contenedor de búsqueda
    document.addEventListener('click', function(event) {
        if (!searchContainer.contains(event.target) && searchContainer.classList.contains('active')) {
            searchContainer.classList.remove('active');
        }
    });
});
