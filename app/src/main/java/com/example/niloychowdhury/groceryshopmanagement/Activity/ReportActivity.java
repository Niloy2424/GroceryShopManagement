package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.niloychowdhury.groceryshopmanagement.Controller.POSManager;
import com.example.niloychowdhury.groceryshopmanagement.Controller.ReportAdapter;
import com.example.niloychowdhury.groceryshopmanagement.Model.POS;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
public ListView pOSLV;
    public ArrayList<POS>sales;
    public POSManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        pOSLV= (ListView) findViewById(R.id.pOSLV);
        manager=new POSManager(this);
        sales=manager.getDailyReport();
        ReportAdapter adapter=new ReportAdapter(this,sales);
        pOSLV.setAdapter(adapter);
    }
}
