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
*(Acá Fede agregá la data de cómo tuneaste la interfaz, colores, etc.)*

## Integrantes
- Grippo Federico - 44752589
- Soto Vela Luciano Ezequiel - 42799718
