package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.niloychowdhury.groceryshopmanagement.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void productsButton(View view) {
        Intent intent=new Intent(this,ProductsActivity.class);
        startActivity(intent);
    }

    public void pointOfSaleButton(View view) {
        Intent intent=new Intent(this,PointOfSaleActivity.class);
        startActivity(intent);
    }

    public void toadysReportButton(View view) {

        Intent intent=new Intent(this,ReportActivity.class);
        startActivity(intent);

    }

    public void stackButton(View view) {
        Intent intent=new Intent(this,StockActivity.class);
        startActivity(intent);
    }
}
