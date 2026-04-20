package com.eskere.tpo3.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.eskere.tpo3.databinding.ActivityMainBinding;
import com.eskere.tpo3.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel vm;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Runnable hideErrorRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = new ViewModelProvider(this).get(MainViewModel.class);

        vm.getLibroEncontrado().observe(this, libro -> {
            if (libro != null) {
                hideError();
                Intent intent = new Intent(this, DetalleActivity.class);
                intent.putExtra("libro_seleccionado", libro);
                startActivity(intent);
            } else {
                showError();
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

    private void showError() {
        // Cancel any pending hide
        if (hideErrorRunnable != null) {
            handler.removeCallbacks(hideErrorRunnable);
        }

        // Make visible but translated below the screen
        binding.tvError.setVisibility(View.VISIBLE);
        binding.tvError.setTranslationY(300f);
        binding.tvError.setAlpha(0f);

        // Animate sliding up and fading in
        binding.tvError.animate()
                .translationY(0f)
                .alpha(1f)
                .setDuration(400)
                .setListener(null)
                .start();

        // Auto-hide after 7 seconds
        hideErrorRunnable = this::hideError;
        handler.postDelayed(hideErrorRunnable, 7000);
    }

    private void hideError() {
        if (hideErrorRunnable != null) {
            handler.removeCallbacks(hideErrorRunnable);
            hideErrorRunnable = null;
        }

        // Animate sliding down and fading out
        binding.tvError.animate()
                .translationY(300f)
                .alpha(0f)
                .setDuration(400)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        binding.tvError.setVisibility(View.GONE);
                    }
                })
                .start();
    }
}
