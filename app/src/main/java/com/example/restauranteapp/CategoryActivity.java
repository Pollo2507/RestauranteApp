package com.example.restauranteapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String categoryName = getIntent().getStringExtra("CATEGORY_NAME");

        ListView listViewProducts = findViewById(R.id.listViewProducts);

        List<Product> productList = new ArrayList<>();

        if ("Entradas".equals(categoryName)) {
            productList.add(new Product("Sopa", R.drawable.soup, "$12,000", "Hecha con vegetales frescos."));
            productList.add(new Product("Ensalada", R.drawable.salad, "$10,000", "Incluye lechuga, tomate y aguacate."));
        } else if ("Platos Principales".equals(categoryName)) {
            productList.add(new Product("Pizza", R.drawable.pizza, "$20,000", "Pizza de queso mozzarella."));
            productList.add(new Product("Hamburguesa", R.drawable.burger, "$15,000", "Con queso cheddar y papas."));
        } else if ("Bebidas".equals(categoryName)) {
            productList.add(new Product("Coca Cola", R.drawable.coke, "$5,000", "Bebida gaseosa refrescante."));
            productList.add(new Product("Jugo de Naranja", R.drawable.ic_launcher_background, "$7,000", "Hecho con naranjas frescas."));
        } else if ("Postres".equals(categoryName)) {
            productList.add(new Product("Cheesecake", R.drawable.cheesecake, "$18,000", "Con cobertura de cereza."));
            productList.add(new Product("Brownie", R.drawable.brownie, "$14,000", "Brownie de chocolate puro."));
        }

        ProductAdapter adapter = new ProductAdapter(this, productList);
        listViewProducts.setAdapter(adapter);

        listViewProducts.setOnItemClickListener((parent, view, position, id) -> {
            Product selectedProduct = productList.get(position);

            CartManager.getInstance().addToCart(selectedProduct);

            Toast.makeText(this, selectedProduct.getName() + " agregado al carrito.", Toast.LENGTH_SHORT).show();
        });
    }
}
