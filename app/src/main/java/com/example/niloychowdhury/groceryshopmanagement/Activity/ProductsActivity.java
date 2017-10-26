package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.niloychowdhury.groceryshopmanagement.R;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
    }

    public void catagaryButton(View view) {

        Intent intent=new Intent(this,CategaryActivity.class);
        startActivity(intent);

    }

    public void subCatagrayButton(View view) {
        Intent intent=new Intent(this,SubCategoryActivity.class);
        startActivity(intent);

    }
}
