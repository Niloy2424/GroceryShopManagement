package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.niloychowdhury.groceryshopmanagement.Controller.CategaryManager;
import com.example.niloychowdhury.groceryshopmanagement.Controller.SpinnerAdapter;
import com.example.niloychowdhury.groceryshopmanagement.Controller.SubCategoryManager;
import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

public class SubCategoryActivity extends AppCompatActivity {
public EditText subCategoryNameET;
public EditText saleET;
public EditText stockET;
public EditText priceET;
    public Button addSubItemButton;
public Spinner categorySpinner;
public Spinner statusSpinner;
    String subCategoryName;
    double sale;
    double stock;
    double price;
    String status;
    int categoryID;
    public CategaryManager categaryManager;
    public ArrayList<Categary>categories;
    public ArrayList<String>categoryNames=new ArrayList<>();
    public SubCategary aSubCategory;
    public SubCategoryManager subCategoryManager;
    public ArrayList<SubCategary>subCategaries;
    public ArrayList<String> statuses;
    public int recivedSubCatageryID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        subCategoryNameET= (EditText) findViewById(R.id.subCategoryNameET);
        saleET= (EditText) findViewById(R.id.saleET);
        stockET= (EditText) findViewById(R.id.stockET);
        priceET= (EditText) findViewById(R.id.priceET);
        categorySpinner= (Spinner) findViewById(R.id.categorySpinner);
        statusSpinner= (Spinner) findViewById(R.id.statusSpinner);
        addSubItemButton= (Button) findViewById(R.id.addSubItemButton);
        addValueInSpinner();
        categaryManager=new CategaryManager(this);
        addValueInCategarySpinner();
        recivedSubCatageryID=getIntent().getIntExtra("SubCategaryIDSent",0);
        Toast.makeText(this, "ggdgdt"+recivedSubCatageryID, Toast.LENGTH_SHORT).show();
        if (recivedSubCatageryID!=0)
        {

            addSubItemButton.setText("UPDATE");
            aSubCategory=subCategoryManager.getSelectedSubCategary(recivedSubCatageryID);
            subCategoryNameET.setText(aSubCategory.getSubCategoryName());
            priceET.setText(String.valueOf(aSubCategory.getPrice()));
            saleET.setText(String.valueOf(aSubCategory.getSale()));
            stockET.setText(String.valueOf(aSubCategory.getStock()));
            statusSpinner.setSelection ( statuses.indexOf(aSubCategory.getStatus()) );
            categorySpinner.setSelection ( categoryNames.indexOf(aSubCategory.getCategoryID()) );
        }





    }

    public void addSubItemButton(View view) {


        sale=Double.valueOf(saleET.getText().toString());
        price=Double.valueOf(priceET.getText().toString());
        stock=Double.valueOf(stockET.getText().toString());
        subCategoryName=subCategoryNameET.getText().toString();
        status=statusSpinner.getSelectedItem().toString();

        aSubCategory=new SubCategary(subCategoryName,sale,stock,price,status,categoryID);
        subCategoryManager = new SubCategoryManager(this);
        boolean insert=subCategoryManager.addSubCategory(aSubCategory);
        if (insert)
        {
            Toast.makeText(this, "Sub Category is Added Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, " Sorry , Sub Category is not Added", Toast.LENGTH_SHORT).show();
        }

    }
    public void addValueInSpinner() {
        statuses = new ArrayList<>();
        statuses.add("Active");
        statuses.add("Inactive");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, statuses);
        // ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.status,android.R.layout.simple_spinner_item);
        statusSpinner.setAdapter(adapter);
    }
    public void addValueInCategarySpinner()
    {

        categories=categaryManager.getAllActiveCategary();
        for (Categary category:categories)
        {
            String categoryName= category.getCategaryName();

            categoryNames.add(categoryName);
        }
        SpinnerAdapter adapter=new SpinnerAdapter(this,categoryNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                categoryID=categories.get(position).getId();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void ShowButton(View view) {

        Intent intent=new Intent(this,ShowItemActivity.class);
        subCategoryManager=new SubCategoryManager(this);
     subCategaries=subCategoryManager.getSubCategory();
      intent.putExtra("SubCategory",subCategaries);
        startActivity(intent);
    }


}
