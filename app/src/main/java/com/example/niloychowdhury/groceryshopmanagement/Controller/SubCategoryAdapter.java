package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

import static com.example.niloychowdhury.groceryshopmanagement.R.id.cTV;
import static com.example.niloychowdhury.groceryshopmanagement.R.id.categoryNameTV;

/**
 * Created by Niloy Chowdhury on 2017-09-09.
 */

public class SubCategoryAdapter extends ArrayAdapter<SubCategary> {
    private ArrayList<SubCategary>subCategaries;
    private CategaryManager manager;
    private Context context;
    public SubCategoryAdapter(@NonNull Context context, ArrayList<SubCategary>subCategaries) {
        super(context, R.layout.items_row_layout,subCategaries);
        this.subCategaries=subCategaries;
        this.context=context;
        manager = new CategaryManager(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.items_row_layout,parent,false);
        TextView nameTV= (TextView) view.findViewById(R.id.subNameTV);
        TextView statusTV= (TextView) view.findViewById(R.id.subStatusTV);
        TextView priceTV= (TextView) view.findViewById(R.id.priceTV);
        TextView stockTV= (TextView) view.findViewById(R.id.stockTV);
        TextView saleTV= (TextView) view.findViewById(R.id.saleTV);
       TextView cNameTV= (TextView) view.findViewById(R.id.cTV);
        nameTV.setText(subCategaries.get(position).getSubCategoryName());
        statusTV.setText(subCategaries.get(position).getStatus());
        priceTV.setText(String.valueOf(subCategaries.get(position).getPrice()));
        saleTV.setText(String.valueOf(subCategaries.get(position).getSale()));
        stockTV.setText(String.valueOf(subCategaries.get(position).getStock()));
        cNameTV.setText(String.valueOf(manager.getCategoryNameById(subCategaries.get(position).getCategoryID())));
        return view;
    }
}
