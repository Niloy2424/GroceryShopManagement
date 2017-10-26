package com.example.niloychowdhury.groceryshopmanagement.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.niloychowdhury.groceryshopmanagement.Controller.CategaryAdapter;
import com.example.niloychowdhury.groceryshopmanagement.Controller.CategaryManager;
import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

public class CategaryActivity extends AppCompatActivity {
    public ListView categaryLV;
    public EditText categoryNameET;
    public Button addItemButton;
    public Spinner statusSpinner;
    String categaryName, status;
    public CategaryManager manager;
    public Categary aCategary;
    public ArrayList<Categary> categeries;
    public CategaryAdapter adapter;
    public int recivedCategoryID;
    public ArrayList<String> statuses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categary);
        categoryNameET = (EditText) findViewById(R.id.categoryNameET);
        statusSpinner = (Spinner) findViewById(R.id.statusSpinner);
        categaryLV = (ListView) findViewById(R.id.categoryLV);
        addItemButton= (Button) findViewById(R.id.addItemButton);
        manager = new CategaryManager(this);
        registerForContextMenu(categaryLV);
       refreshListView();
        addValueInSpinner();
        recivedCategoryID=getIntent().getIntExtra("cid",0);
        if (recivedCategoryID!=0)
       {
           addItemButton.setText("UPDATE");
           aCategary=manager.getSelectedCategory(recivedCategoryID);
            categoryNameET.setText(aCategary.getCategryName());
            statusSpinner.setSelection ( statuses.indexOf(aCategary.getStatus()) );

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

    public void addItemButton(View view) {

        categaryName = categoryNameET.getText().toString();

        status = statusSpinner.getSelectedItem().toString();
        if (!categaryName.isEmpty())
        {
            aCategary = new Categary(categaryName, status);
if (recivedCategoryID==0)
{



    boolean insert = manager.addCatagery(aCategary);
    if (insert) {
        Toast.makeText(this, "Successfully inserted", Toast.LENGTH_SHORT).show();
    } else {
        Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }
    refreshListView();
}
else
{
    boolean updated=manager.updateStudent(aCategary,recivedCategoryID);
    if (updated)
    {
        Toast.makeText(this, "Category is updated", Toast.LENGTH_SHORT).show();
    }
    else
    {
        Toast.makeText(this, "Sorry , Category is not updated", Toast.LENGTH_SHORT).show();
    }
    refreshListView();
}



        }
        else

        {
            Toast.makeText(this, "Please insert Category Name", Toast.LENGTH_SHORT).show();
        }

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Menu");
        menu.add(0,v.getId(),1,"Edit");
        menu.add(0,v.getId(),2,"Delete");
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int index=info.position;
        final int categoryID= categeries.get(index).getId();
        if (item.getTitle()=="Edit")
        {
            Intent intent=new Intent(CategaryActivity.this,CategaryActivity.class);
            intent.putExtra("cid",categoryID);

            startActivity(intent);
        }
        else if (item.getTitle()=="Delete")
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Delete");
            builder.setMessage("Are you sure");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //contacts.remove(index);
                    // RefreshData();
                 boolean deleted=  manager.deleteCategory(categoryID);
                    if (deleted)
                    {
                        Toast.makeText(CategaryActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                        refreshListView();
                    }
                    else
                        Toast.makeText(CategaryActivity.this, "Error in delete", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
        return super.onContextItemSelected(item);
    }


    public void resetButton(View view) {
    }

    public void refreshListView() {
        categeries = manager.getAllCategary();
        adapter = new CategaryAdapter(this, categeries);
        categaryLV.setAdapter(adapter);
    }
}
