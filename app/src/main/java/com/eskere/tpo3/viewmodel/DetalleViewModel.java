package com.eskere.tpo3.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.eskere.tpo3.model.Libro;

public class DetalleViewModel extends ViewModel {
    // mutable para guardar el libro seleccionado
    private MutableLiveData<Libro> libroSeleccionado = new MutableLiveData<>();

    // la Activity observa los datos
    public LiveData<Libro> getLibroSeleccionado() {
        return libroSeleccionado;
    }
    public void setLibro(Libro libro) {
        libroSeleccionado.setValue(libro); // Lo metemos al mutable
    }
}
