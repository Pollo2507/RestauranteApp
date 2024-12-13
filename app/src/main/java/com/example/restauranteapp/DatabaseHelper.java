package com.example.restauranteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RestauranteDB";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CART = "Cart";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_QUANTITY = "quantity";

    private static final String CREATE_TABLE_CART =
            "CREATE TABLE " + TABLE_CART + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PRICE + " REAL, " +
                    COLUMN_QUANTITY + " INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CART);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        onCreate(db);
    }

    public void addToCart(String name, double price, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PRICE, price);
        values.put(COLUMN_QUANTITY, quantity);
        db.insert(TABLE_CART, null, values);
        db.close();
    }

    public Cursor getCartItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CART, null);
    }

    public void clearCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, null, null);
        db.close();
    }
}
