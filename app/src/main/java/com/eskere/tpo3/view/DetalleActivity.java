package com.eskere.tpo3.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.eskere.tpo3.databinding.ActivityDetalleBinding;
import com.eskere.tpo3.model.Libro;
import com.eskere.tpo3.viewmodel.DetalleViewModel;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    private DetalleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(DetalleViewModel.class);

        binding.btnBack.setOnClickListener(v -> finish());

        //agarrar el libro que viene viajando en el Intent
        Libro libroRecibido = (Libro) getIntent().getSerializableExtra("libro_seleccionado");

        // pasamos el libro al viewmodel
        if (libroRecibido != null) {
            viewModel.setLibro(libroRecibido);
        }

        // actualizar la interfaz observando los cambios del libro
        viewModel.getLibroSeleccionado().observe(this, libro -> {
            if (libro != null) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvAutor.setText("Autor: " + libro.getAutor());
                binding.tvDescripcion.setText("Descripción: " + libro.getDescripcion());
                binding.tvAnio.setText("Año: " + String.valueOf(libro.getAnio()));
                binding.imageView.setImageResource(libro.getImagenResId());
            }
        });
    }
}
