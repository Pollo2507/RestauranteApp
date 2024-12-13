package com.example.restauranteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList != null ? productList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        }

        Product product = productList.get(position);

        ImageView imgProduct = convertView.findViewById(R.id.imgProduct);
        TextView tvProductName = convertView.findViewById(R.id.tvProductName);
        TextView tvProductPrice = convertView.findViewById(R.id.tvProductPrice);
        TextView tvProductDescription = convertView.findViewById(R.id.tvProductDescription);
        Button btnAddToCart = convertView.findViewById(R.id.btnAddToCart);

        imgProduct.setImageResource(product.getImageResId());
        tvProductName.setText(product.getName());
        tvProductPrice.setText(product.getPrice());
        tvProductDescription.setText(product.getDescription());

        btnAddToCart.setOnClickListener(v -> {
            Cart.addProduct(product);
            Toast.makeText(context, product.getName() + " agregado al carrito.", Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }
}
