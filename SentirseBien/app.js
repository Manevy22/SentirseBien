const express = require('express');
const path = require('path');
const app = express();

// Configurar la carpeta raíz para servir archivos estáticos
app.use(express.static(path.join(__dirname)));

// Servir index.html cuando se acceda a la raíz
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname,'index.html'));
});

// Iniciar servidor en el puerto 8080
const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://127.0.0.1:${PORT}`);
});
