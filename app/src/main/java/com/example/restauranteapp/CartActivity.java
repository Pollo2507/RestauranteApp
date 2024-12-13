package com.example.restauranteapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<Product> cartItems; // Carrito temporal
    private double total = 0; // Total acumulado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Vincular vistas del layout
        ListView listViewCart = findViewById(R.id.listViewCart);
        TextView tvTotalPrice = findViewById(R.id.tvTotalPrice);
        Button btnClearCart = findViewById(R.id.btnClearCart);

        // Obtener productos del carrito temporal
        cartItems = CartManager.getInstance().getCartItems();

        // Calcular el total
        for (Product product : cartItems) {
            total += Double.parseDouble(product.getPrice().replace("$", "").replace(",", ""));
        }

        // Mostrar el total
        tvTotalPrice.setText("Total: $" + total);

        // Configurar adaptador para mostrar los productos
        if (!cartItems.isEmpty()) {
            ProductAdapter adapter = new ProductAdapter(this, cartItems);
            listViewCart.setAdapter(adapter);
        } else {
            Toast.makeText(this, "El carrito está vacío.", Toast.LENGTH_SHORT).show();
        }

        // Acción para vaciar el carrito
        btnClearCart.setOnClickListener(v -> {
            CartManager.getInstance().clearCart(); // Vaciar el carrito temporal
            Toast.makeText(this, "Carrito vacío.", Toast.LENGTH_SHORT).show();
            finish(); // Cierra la actividad para actualizar la vista
        });
    }
}
