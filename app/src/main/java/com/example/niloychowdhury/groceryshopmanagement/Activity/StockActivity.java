package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.niloychowdhury.groceryshopmanagement.Controller.StockAdapter;
import com.example.niloychowdhury.groceryshopmanagement.Controller.SubCategoryManager;
import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

public class StockActivity extends AppCompatActivity {
public ListView stockLV;
    public ArrayList<SubCategary>subCategaries;
    public SubCategoryManager subCategoryManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        stockLV= (ListView) findViewById(R.id.stockLV);
        subCategoryManager=new SubCategoryManager(this);
       subCategaries=subCategoryManager.getSubCategory();
        StockAdapter adapter=new StockAdapter(this,subCategaries);
        stockLV.setAdapter(adapter);

    }
}
