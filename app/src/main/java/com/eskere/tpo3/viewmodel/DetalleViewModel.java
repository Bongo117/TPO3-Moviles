package com.eskere.tpo3.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.eskere.tpo3.model.Libro;

public class DetalleViewModel extends ViewModel {

    private MutableLiveData<Libro> libroMutable = new MutableLiveData<>();

    public LiveData<Libro> getLibro() {
        return libroMutable;
    }

    // extraer el libro del intent y ponerlo en livedata
    public void cargarLibro(Intent intent) {
        if (intent != null && intent.hasExtra("libro")) {
            Libro libro = (Libro) intent.getSerializableExtra("libro");
            libroMutable.setValue(libro);
        }
    }
}