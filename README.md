#TPO 3 - Buscador de Libros 📚
## Descripción de la App
Esta es una aplicación en Android que funciona como un buscador de libros. Cuenta con dos pantallas principales:
- **Buscador (MainActivity):** Una pantalla inicial donde el usuario ingresa el nombre de un libro.
- **Detalles (DetalleActivity):** Si el libro existe en nuestra lista simulada, se abre esta segunda pantalla mostrando la portada, el título, el autor, el año y la descripción. Si el libro no existe, salta un aviso (Toast) indicando que no se encontró.

## Se usó el patrón **MVVM**
- **Model (`Libro`):** Es la clase de los datos del libro. Le implementamos Serializable` para poder enviar el objeto entero de una pantalla a otra mediante el Intent.
- **ViewModel (`MainViewModel` y `DetalleViewModel`):** Acá está la lógica de la app.El *MainViewModel* tiene la lista de libros y se encarga de hacer la búsqueda, mientras que el *DetalleViewModel* recibe el libro y lo prepara. Nos comunicamos con las vistas usando `MutableLiveData`.
- **View (`MainActivity`, `DetalleActivity` y los XML):**Se encargan de escuchar los clicks del usuario y observar al ViewModel para actualizar los textos y las imágenes. Usamos **ViewBinding** en ambas para conectar los elementos visuales.

## Diseño de la interfaz
Se estableció un degradado violeta a negro de fondo en toda la app. El buscador ahora es una "cápsula" con ícono de lupa, y el botón de búsqueda es un elemento sólido de alto contraste. Los mensajes de "Libro no encontrado" ya no son Toasts aburridos; ahora son carteles que se deslizan desde abajo y desaparecen solos tras 7 segundos. Se centró todo el contenido y se aplicó una estructura tipo web (H1 para títulos, H2 para autores) para una lectura mucho más cómoda. Se agregó un botón de volver estilizado y se aplicaron bordes redondeados a la imagen del libro para suavizar el diseño.

## Integrantes
- Grippo Federico - 44752589
- Soto Vela Luciano Ezequiel - 42799718
