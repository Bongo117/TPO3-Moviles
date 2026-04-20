package com.eskere.tpo3.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.eskere.tpo3.R;
import com.eskere.tpo3.model.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private List<Libro> listaLibros;
    private MutableLiveData<Libro> libroEncontrado = new MutableLiveData<>();

    public MainViewModel() {
        // Inicializamos nuestra "base de datos" local
        listaLibros = new ArrayList<>();
        // Dentro del constructor de MainViewModel
        listaLibros.add(new Libro("Meditaciones", "Marco Aurelio", "Reflexiones estoicas", R.drawable.meditaciones, 170));
        listaLibros.add(new Libro("Harry Potter", "J.K. Rowling", "Un niño descubre que es mago.", R.drawable.harry, 1997));
        listaLibros.add(new Libro("El Quijote", "Miguel de Cervantes", "Un hidalgo loco por los libros de caballería", R.drawable.quijote, 1605));
        listaLibros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", "Una historia sobre la amistad y el sentido de la vida.", R.drawable.principito, 1943));
        listaLibros.add(new Libro("El hobbit", "J.R.R. Tolkien", "Una aventura épica en la Tierra Media.", R.drawable.hobbit, 1937));
    }

    // Exponemos el LiveData
    public LiveData<Libro> getLibroEncontrado() {
        return libroEncontrado;
    }

    // busqueda
    public void buscarLibro(String tituloIngresado) {
        if (tituloIngresado == null || tituloIngresado.isEmpty()) {
            return; // Este return solo corta la ejecucion, no devuelve datos.
        }

        Libro resultado = null;

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloIngresado)) {
                resultado = libro;
                break;
            }
        }

        libroEncontrado.setValue(resultado);
    }
}
