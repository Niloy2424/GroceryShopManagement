package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Niloy Chowdhury on 2017-08-31.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
static final String DATABASE_NAME="GreceryShop.db";
    static final int DATABASE_VERSION=1;
    static final String TABLE_NAME_CATEGARY="categary";
    static final String TABLE_NAME_SUBCATEGARY="subcategary";
    static final String TABLE_NAME_POS="pos";
    static final String CATEGARY_ID="cid";
    static final String SUBCATEGARY_ID="scid";
     static final String CATAGORY_NAME="name";
    static final String ITEM_NAME="name";
    static final String PRICE="price";
    static final String STOCK="stock";
    static final String STATUS="status";
    static final String SALE="sale";
    static final String SALE_QUANTITY="sale_quantity";
    static final String SALE_PRICE="sale_price";
    static final String SALE_ID="sale_id";

    static final String CREATED_AT="create_at";

    String CREATE_TABLE_CATEGORY="CREATE TABLE " + TABLE_NAME_CATEGARY + " ( "
            + CATEGARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CATAGORY_NAME + " TEXT, "
            + CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            +  STATUS + " TEXT) ";
    String CREATE_TABLE_POS="CREATE TABLE " + TABLE_NAME_POS + " ( "
            + SALE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CATEGARY_ID + " INTEGER, "
            + SUBCATEGARY_ID + " INTEGER, "
            + SALE_QUANTITY + " TEXT, "
            + CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            +  SALE_PRICE + " TEXT) ";

    String CREATE_TABLE_SUBCATEGARY="CREATE TABLE " + TABLE_NAME_SUBCATEGARY + " ( "
            + SUBCATEGARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CATEGARY_ID + " INTEGER, "
            + ITEM_NAME + " TEXT, "
            + PRICE + " REAL, "
            + STOCK + " REAL, "
            + SALE + " REAL, "
            + CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            + STATUS + " TEXT) ";
           // + CATEGARY_ID + " INTEGER REFERENCES " + TABLE_NAME_CATEGARY + ")";
            //+ " FOREIGN KEY ("+CATEGARY_ID+") REFERENCES "+TABLE_NAME_CATEGARY+"("+CATEGARY_ID+"));";
           // + " FOREIGN KEY ("+CATEGARY_ID+") REFERENCES "+TABLE_NAME_CATEGARY+"("+CATEGARY_ID+"));";
    //TASK_CAT+" INTEGER REFERENCES "+CAT_TABLE+");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_SUBCATEGARY);
        db.execSQL(CREATE_TABLE_POS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
