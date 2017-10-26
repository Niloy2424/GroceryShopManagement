package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.niloychowdhury.groceryshopmanagement.Controller.SubCategoryAdapter;
import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

public class ShowItemActivity extends AppCompatActivity {
public ListView subCategoryLV;
    int subcategoryID;
    private ArrayList<SubCategary>subCategaries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);
        subCategoryLV= (ListView) findViewById(R.id.itemsLV);
        subCategaries= (ArrayList<SubCategary>) getIntent().getSerializableExtra("SubCategory");
//        for (SubCategary aSubCategory:subCategaries) {
//
//            Toast.makeText(this, ""+aSubCategory.getCategoryID(), Toast.LENGTH_SHORT).show();
//        }
       SubCategoryAdapter adapter=new SubCategoryAdapter(this,subCategaries);

       subCategoryLV.setAdapter(adapter);
        registerForContextMenu(subCategoryLV);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu");
        menu.add(0,v.getId(),1,"Edit");
        menu.add(0,v.getId(),2,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {



        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index=info.position;
        subcategoryID=subCategaries.get(index).getSubCategoryID();

        if (item.getTitle()=="Edit")
        {


            Intent intent=new Intent(this,SubCategoryActivity.class);
            intent.putExtra("SubCategaryIDSent",subcategoryID);
            startActivity(intent);
        }
        else if (item.getTitle()=="Delete")
        {

        }
        return super.onContextItemSelected(item);
    }
}
