package com.eskere.tpo3.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.eskere.tpo3.R;
import com.eskere.tpo3.model.Libro;
import com.eskere.tpo3.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText etTitulo;
    private Button btBuscar;
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitulo = findViewById(R.id.etTitulo);
        btBuscar = findViewById(R.id.btBuscar);

        vm = new ViewModelProvider(this).get(MainViewModel.class);
        vm.getLibroEncontrado().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                if (libro != null) {
                    Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                    intent.putExtra("libro", libro); // Pasamos el objeto Serializable
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el botón
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreLibro = etTitulo.getText().toString();
                if (!nombreLibro.isEmpty()) {
                    vm.buscarLibro(nombreLibro);
                } else {
                    etTitulo.setError("Escribe un título");
                }
            }
        });
    }
}