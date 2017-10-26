package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.Model.POS;

import java.util.ArrayList;

/**
 * Created by Niloy Chowdhury on 2017-09-13.
 */

public class POSManager {
    private POS pOS;
    private DatabaseHelper helper;
    public SQLiteDatabase database;

    public void open()
    {
        database=helper.getWritableDatabase();
    }
    public void close()
    {
        helper.close();
    }
    public POSManager(Context context) {

        helper=new DatabaseHelper(context);
    }

    public boolean addPOS(POS aPos) {
        this.open();

        ContentValues contentvalue=new ContentValues();
        contentvalue.put(helper.SALE_QUANTITY,aPos.getQuantity());
        contentvalue.put(helper.CATEGARY_ID,aPos.getCategoryID());
        contentvalue.put(helper.SUBCATEGARY_ID,aPos.getSubCategoryID());
        contentvalue.put(helper.SALE_PRICE,aPos.getPrice());
        long insert= database.insert(helper.TABLE_NAME_POS,null,contentvalue);
        this.close();
        if (insert>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public ArrayList<POS> getDailyReport() {

        ArrayList<POS>sales=new ArrayList<>();
        this.open();
        Cursor cursor=database.query(DatabaseHelper.TABLE_NAME_POS,null,null,null,null,null,null);
        if (cursor!=null&&cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                int _id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.SALE_ID));
                int _cid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.CATEGARY_ID));
                int _subid = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.SUBCATEGARY_ID));
                double price=cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.SALE_PRICE));
                String dateTime=cursor.getString(cursor.getColumnIndex(DatabaseHelper.CREATED_AT));
                double quantity=cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.SALE_QUANTITY));
                pOS=new POS(_cid,_subid,_id,quantity,price,dateTime);

                sales.add(pOS);
            }
        }



        this.close();
        return sales;

    }
}
