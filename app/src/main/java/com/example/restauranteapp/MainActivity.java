package com.example.restauranteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular botones del layout con sus IDs
        Button btnEntradas = findViewById(R.id.btnEntradas);
        Button btnPlatosPrincipales = findViewById(R.id.btnPlatosPrincipales);
        Button btnBebidas = findViewById(R.id.btnBebidas);
        Button btnPostres = findViewById(R.id.btnPostres);
        Button btnViewCart = findViewById(R.id.btnViewCart);

        // Configurar clics en los botones
        btnEntradas.setOnClickListener(v -> openCategory("Entradas"));
        btnPlatosPrincipales.setOnClickListener(v -> openCategory("Platos Principales"));
        btnBebidas.setOnClickListener(v -> openCategory("Bebidas"));
        btnPostres.setOnClickListener(v -> openCategory("Postres"));
        btnViewCart.setOnClickListener(v -> openCart());
    }

    // Método para abrir la actividad de categorías
    private void openCategory(String category) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("CATEGORY_NAME", category); // Pasar el nombre de la categoría
        startActivity(intent);
    }

    // Método para abrir la actividad del carrito
    private void openCart() {
        Intent intent = new Intent(this, CartActivity.class); // Iniciar actividad del carrito
        startActivity(intent);
    }
}
