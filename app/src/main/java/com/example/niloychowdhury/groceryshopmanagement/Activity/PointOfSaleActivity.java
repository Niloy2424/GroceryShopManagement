package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.niloychowdhury.groceryshopmanagement.Controller.CategaryManager;
import com.example.niloychowdhury.groceryshopmanagement.Controller.POSManager;
import com.example.niloychowdhury.groceryshopmanagement.Controller.SpinnerAdapter;
import com.example.niloychowdhury.groceryshopmanagement.Controller.SubCategoryManager;
import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.Model.POS;
import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

public class PointOfSaleActivity extends AppCompatActivity {
public Spinner pOICategarySpinner;
public Spinner pOIItemSpinner;
    public EditText quantityET;
    public EditText priceET;
    public ArrayList<Categary>categories;
    public ArrayList<SubCategary>subCategories;
    public CategaryManager categaryManager;
    public SubCategoryManager subCategoryManager;
    public int categoryID,selectedSubcategoryID;
    public SubCategary aSubCategory;
    public POS aPos;
    public POSManager manager;
    double quantity,price;
    double finalQuantity;
    double finalSale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_of_sale);
        pOICategarySpinner= (Spinner) findViewById(R.id.pOICategorySpinner);
        pOIItemSpinner= (Spinner) findViewById(R.id.pOIItemSpinner);
        quantityET= (EditText) findViewById(R.id.pOIQuantityET);
        priceET= (EditText) findViewById(R.id.pOIPriceET);
        categaryManager=new CategaryManager(this);
        subCategoryManager=new SubCategoryManager(this);
         manager=new POSManager(this);
        addValueInCategarySpinner();
    }

    public void saveButton(View view) {
if (quantityET.getText().toString().isEmpty()&&priceET.getText().toString().isEmpty())
{
    Toast.makeText(this, "Give Quantity And Price", Toast.LENGTH_SHORT).show();
}
else {
    quantity = Double.valueOf(quantityET.getText().toString());

    price = Double.valueOf(priceET.getText().toString());

    aSubCategory = subCategoryManager.getSelectedSubCategary(selectedSubcategoryID);
    if (aSubCategory.getStock() > quantity) {
        finalQuantity = aSubCategory.getStock() - quantity;
        finalSale = aSubCategory.getSale() + quantity;
        SubCategary subcategory = new SubCategary(aSubCategory.getSubCategoryName(), finalSale, finalQuantity, aSubCategory.getPrice(), aSubCategory.getStatus(), categoryID);
        boolean update = subCategoryManager.updateSubCategory(subcategory, selectedSubcategoryID);
        if (update) {
            Toast.makeText(this, "Stock is updated ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Stock is not updated", Toast.LENGTH_SHORT).show();
        }
        aPos = new POS(categoryID, selectedSubcategoryID, quantity, price);
        boolean insert = manager.addPOS(aPos);
        if (insert) {
            Toast.makeText(this, "Sale Record Is Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sale record isn't inserted", Toast.LENGTH_SHORT).show();
        }

    } else {
        Toast.makeText(this, "You don't have Enough Stock.Your stock for this item is=" + aSubCategory.getStock(), Toast.LENGTH_LONG).show();
    }


}

    }
    public void addValueInCategarySpinner()
    {

        categories=categaryManager.getAllActiveCategary();
         ArrayList<String>categoryNames=new ArrayList<>();
        for (Categary category:categories)
        {
            String categoryName= category.getCategaryName();

            categoryNames.add(categoryName);
        }
       SpinnerAdapter adapter=new SpinnerAdapter(this,categoryNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pOICategarySpinner.setAdapter(adapter);
        pOICategarySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                categoryID=categories.get(position).getId();
                addValueInSubcategorySpinner();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void addValueInSubcategorySpinner()
    {

subCategories=subCategoryManager.getSelectedSubCategaryByCategory(categoryID);
         ArrayList<String>subItemNames=new ArrayList<>();
        for (SubCategary subCategory:subCategories)
        {
            String subCategoryNames=subCategory.getSubCategoryName();

            subItemNames.add(subCategoryNames);
        }
        SpinnerAdapter adapter=new SpinnerAdapter(this,subItemNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pOIItemSpinner.setAdapter(adapter);
        pOIItemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             selectedSubcategoryID=subCategories.get(position).subCategoryID;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
