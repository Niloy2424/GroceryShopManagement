package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;

import java.util.ArrayList;

/**
 * Created by Niloy Chowdhury on 2017-09-09.
 */

public class SubCategoryManager {
    private SubCategary subCategory;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;


    public void open() {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
    }

    public SubCategoryManager(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public boolean addSubCategory(SubCategary aSubCategory) {

        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.ITEM_NAME, aSubCategory.getSubCategoryName());
        contentValues.put(DatabaseHelper.CATEGARY_ID, aSubCategory.getCategoryID());
        contentValues.put(DatabaseHelper.STATUS, aSubCategory.getStatus());
        contentValues.put(DatabaseHelper.PRICE, aSubCategory.getPrice());
        contentValues.put(DatabaseHelper.STOCK, aSubCategory.getStock());
        contentValues.put(DatabaseHelper.SALE, aSubCategory.getSale());
        long insert = sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME_SUBCATEGARY, null, contentValues);
        this.close();
        if (insert > 0) {
            return true;
        } else {

            return false;
        }


    }

    public ArrayList<SubCategary> getSubCategory() {
        ArrayList<SubCategary> subCategories = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME_SUBCATEGARY, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(databaseHelper.SUBCATEGARY_ID));
                int cid = cursor.getInt(cursor.getColumnIndex(databaseHelper.CATEGARY_ID));
                String subCategoryName = cursor.getString(cursor.getColumnIndex(databaseHelper.ITEM_NAME));
                double price = cursor.getDouble(cursor.getColumnIndex(databaseHelper.PRICE));
                double stock = cursor.getDouble(cursor.getColumnIndex(databaseHelper.STOCK));
                double sale = cursor.getDouble(cursor.getColumnIndex(databaseHelper.SALE));
                String status = cursor.getString(cursor.getColumnIndex(databaseHelper.STATUS));
                String datetime=cursor.getString(cursor.getColumnIndex(databaseHelper.CREATED_AT));
                subCategory = new SubCategary(id, subCategoryName, sale, stock, price, status,cid,datetime);
                subCategories.add(subCategory);
            }


            this.close();

        }
        return subCategories;
    }

    public SubCategary getSelectedSubCategary(int recivedSubCategoryID) {

        this.open();
        Cursor cursor=sqLiteDatabase.query(databaseHelper.TABLE_NAME_SUBCATEGARY,null,databaseHelper.SUBCATEGARY_ID + " = " + recivedSubCategoryID,null,null,null,null);
        if (cursor!=null&&cursor.getCount()>0)
        {
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndex(databaseHelper.SUBCATEGARY_ID));
            int cid = cursor.getInt(cursor.getColumnIndex(databaseHelper.CATEGARY_ID));
            String subCategoryName = cursor.getString(cursor.getColumnIndex(databaseHelper.ITEM_NAME));
            double price = cursor.getDouble(cursor.getColumnIndex(databaseHelper.PRICE));
            double stock = cursor.getDouble(cursor.getColumnIndex(databaseHelper.STOCK));
            double sale = cursor.getDouble(cursor.getColumnIndex(databaseHelper.SALE));
            String status = cursor.getString(cursor.getColumnIndex(databaseHelper.STATUS));
            String datetime=cursor.getString(cursor.getColumnIndex(databaseHelper.CREATED_AT));
            subCategory = new SubCategary(id, subCategoryName, sale, stock, price, status,cid,datetime);

        }
        this.close();


        return subCategory;


    }

    public ArrayList<SubCategary> getSelectedSubCategaryByCategory(int categoryID) {
        ArrayList<SubCategary> subCategories = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME_SUBCATEGARY, null, DatabaseHelper.CATEGARY_ID + "=" + categoryID, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(databaseHelper.SUBCATEGARY_ID));
                int cid = cursor.getInt(cursor.getColumnIndex(databaseHelper.CATEGARY_ID));
                String subCategoryName = cursor.getString(cursor.getColumnIndex(databaseHelper.ITEM_NAME));
                double price = cursor.getDouble(cursor.getColumnIndex(databaseHelper.PRICE));
                double stock = cursor.getDouble(cursor.getColumnIndex(databaseHelper.STOCK));
                double sale = cursor.getDouble(cursor.getColumnIndex(databaseHelper.SALE));
                String status = cursor.getString(cursor.getColumnIndex(databaseHelper.STATUS));
                String datetime=cursor.getString(cursor.getColumnIndex(databaseHelper.CREATED_AT));
                subCategory = new SubCategary(id, subCategoryName, sale, stock, price, status,cid,datetime);
                subCategories.add(subCategory);
            }


            this.close();

        }
        return subCategories;
    }


    public boolean updateSubCategory(SubCategary subcategory, int selectedSubcategoryID) {
        this.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.ITEM_NAME, subcategory.getSubCategoryName());
        contentValues.put(DatabaseHelper.CATEGARY_ID, subcategory.getCategoryID());
        contentValues.put(DatabaseHelper.STATUS, subcategory.getStatus());
        contentValues.put(DatabaseHelper.PRICE, subcategory.getPrice());
        contentValues.put(DatabaseHelper.STOCK, subcategory.getStock());
        contentValues.put(DatabaseHelper.SALE, subcategory.getSale());

        long update= sqLiteDatabase.update(DatabaseHelper.TABLE_NAME_SUBCATEGARY,contentValues,DatabaseHelper.SUBCATEGARY_ID + "=" +selectedSubcategoryID,null);

        this.close();
        if (update>0)
        {
            return true;
        }
        else
        {
            return false;
        }


    }
}
