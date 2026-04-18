package com.eskere.tpo3.view;

import android.content.Intent;import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.eskere.tpo3.databinding.ActivityMainBinding;
import com.eskere.tpo3.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(MainViewModel.class);


        vm.getLibroEncontrado().observe(this, libro -> {
            if (libro != null) {
                Intent intent = new Intent(this, DetalleActivity.class);
                intent.putExtra("libro", libro);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
            }
        });


        binding.btBuscar.setOnClickListener(v -> {
            String nombreLibro = binding.etTitulo.getText().toString();
            if (!nombreLibro.isEmpty()) {
                vm.buscarLibro(nombreLibro);
            } else {
                binding.etTitulo.setError("Escribe un título");
            }
        });
    }
}