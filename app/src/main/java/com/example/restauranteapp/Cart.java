package com.example.restauranteapp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart {
    private static List<Product> cartItems = new ArrayList<>();

    public static void addProduct(Product product) {
        cartItems.add(product);
    }

    public static void removeProduct(Product product) {
        cartItems.remove(product);
    }

    public static List<Product> getCartItems() {
        return cartItems;
    }

    public static String getTotal() {
        double total = 0;

        for (Product product : cartItems) {
            total += Double.parseDouble(product.getPrice().replace("$", "").replace(",", ""));
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        return formatter.format(total);
    }
    
    public static void clearCart() {
        cartItems.clear();
    }
}
