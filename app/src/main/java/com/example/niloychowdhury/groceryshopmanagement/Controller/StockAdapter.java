package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.niloychowdhury.groceryshopmanagement.Model.SubCategary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

/**
 * Created by Niloy Chowdhury on 2017-09-14.
 */

public class StockAdapter extends ArrayAdapter<SubCategary> {
    private ArrayList<SubCategary> subCategaries;
    private Context context;
    public StockAdapter(@NonNull Context context, ArrayList<SubCategary>subCategaries) {
        super(context, R.layout.items_row_layout,subCategaries);
        this.subCategaries=subCategaries;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.stock_row_layout,parent,false);

        TextView nameTV= (TextView) view.findViewById(R.id.nameTV);
        TextView statusTV= (TextView) view.findViewById(R.id.statusTV);
        TextView stockTV= (TextView) view.findViewById(R.id.stockTV);
        TextView categoryTV= (TextView) view.findViewById(R.id.categoryTV);

        nameTV.setText(subCategaries.get(position).getSubCategoryName());
        statusTV.setText(subCategaries.get(position).getStatus());
        stockTV.setText(String.valueOf(subCategaries.get(position).getStock()));
        categoryTV.setText(String.valueOf(subCategaries.get(position).getCategoryID()));
        return view;
    }
}
