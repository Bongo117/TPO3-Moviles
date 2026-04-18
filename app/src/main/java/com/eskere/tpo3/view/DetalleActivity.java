package com.eskere.tpo3.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.eskere.tpo3.databinding.ActivityDetalleBinding; // Importación del Binding
import com.eskere.tpo3.viewmodel.DetalleViewModel;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding; // 1. Declarar el binding
    private DetalleViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. Inicializar ViewBinding
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(DetalleViewModel.class);


        vm.getLibro().observe(this, libro -> {
            if (libro != null) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvAutor.setText("Escrito por: " + libro.getAutor());
                binding.tvDescripcion.setText("Descripción:\n" + libro.getDescripcion());
                binding.imageView.setImageResource(libro.getImagenResId());
                binding.tvAnio.setText("Año de publicación: " + libro.getAnio());
            }
        });

        // pal ViewModel
        vm.cargarLibro(getIntent());
    }
}