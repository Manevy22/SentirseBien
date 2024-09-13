document.addEventListener('DOMContentLoaded', () => {
    const testimonialForm = document.getElementById('testimonialForm');
    const testimonialContainer = document.getElementById('testimonialContainer');

    // Cargar testimonios guardados desde la API al cargar la página
    loadTestimonials();

    // Manejar el envío del formulario de testimonio
    if (testimonialForm) { // Verificar si existe testimonialForm antes de añadir el listener
        testimonialForm.addEventListener('submit', async (event) => {
            event.preventDefault();

            // Obtener los valores del formulario
            const nombre = document.getElementById('nombre').value;
            const testimonio = document.getElementById('testimonio').value;

            // Crear un objeto de testimonio
            const newTestimonial = {
                nombre,
                testimonio
            };

            try {
                // Guardar el testimonio en la API
                const response = await fetch('http://localhost:8081/Testimonio/crear', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(newTestimonial)
                });

                if (response.ok) {
                    // Agregar el nuevo testimonio al contenedor
                    addTestimonialToPage(newTestimonial);
                    // Resetear el formulario
                    testimonialForm.reset();
                } else {
                    console.error('Error al guardar el testimonio.');
                }
            } catch (error) {
                console.error('Error de conexión:', error);
            }
        });
    }

    // Función para cargar testimonios guardados desde la API
    async function loadTestimonials() {
        try {
            const response = await fetch('http://localhost:8081/Testimonio/traer');
            const testimonials = await response.json();

            testimonials.forEach(testimonial => {
                addTestimonialToPage(testimonial);
            });

            // Inicializar el carrusel después de agregar los testimonios
            $('#testimonialCarousel').carousel();
        } catch (error) {
            console.error('Error al cargar los testimonios:', error);
        }
    }

    // Función para agregar un testimonio al contenedor de la página
    function addTestimonialToPage(testimonial) {
        const testimonialDiv = document.createElement('div');
        testimonialDiv.className = 'carousel-item';

        // Si es la primera diapositiva, agregar la clase 'active'
        if (testimonialContainer.children.length === 0) {
            testimonialDiv.classList.add('active');
        }

        testimonialDiv.innerHTML = `
            <div class="position-relative">
                <i class="fa fa-3x fa-quote-right text-primary position-absolute" style="top: -6px; right: 0;"></i>
                <div class="d-flex align-items-center mb-3">
                    <img class="img-fluid rounded-circle" src="img/testimonial-2.jpg" style="width: 60px; height: 60px;" alt="">
                    <div class="ml-3">
                        <h6 class="text-uppercase">${testimonial.nombre}</h6>
                        <span>Cliente</span> <!-- Aquí podrías colocar un rol o dejarlo fijo -->
                    </div>
                </div>
                <p class="m-0">${testimonial.testimonio}</p>
            </div>
        `;

        // Agregar el testimonio al contenedor de testimonios
        testimonialContainer.appendChild(testimonialDiv);
    }
});
