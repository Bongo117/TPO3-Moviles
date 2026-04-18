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
        // Inicializamos una lista de prueba
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Harry Potter", "J.K. Rowling", "Un niño descubre que es mago.", R.drawable.ic_launcher_background));
        listaLibros.add(new Libro("El Quijote", "Miguel de Cervantes", "Un hidalgo loco por los libros de caballería.", R.drawable.ic_launcher_background));
        listaLibros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", "Una historia sobre la amistad y el sentido de la vida.", R.drawable.ic_launcher_background));
    }

    // Exponemos el LiveData para que la Activity lo observe
    public LiveData<Libro> getLibroEncontrado() {
        return libroEncontrado;
    }

    // Lógica para buscar el libro por título
    public void buscarLibro(String tituloIngresado) {
        if (tituloIngresado == null || tituloIngresado.isEmpty()) return;

        for (Libro libro : listaLibros) {
            // Buscamos ignorando mayúsculas y minúsculas
            if (libro.getTitulo().equalsIgnoreCase(tituloIngresado)) {
                libroEncontrado.setValue(libro);
                return;
            }
        }
        // Si no lo encuentra, podemos setear null
        libroEncontrado.setValue(null);
    }
}