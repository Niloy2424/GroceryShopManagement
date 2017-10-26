package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.Model.POS;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

/**
 * Created by Niloy Chowdhury on 2017-09-13.
 */

public class ReportAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<POS> sales;
    public ReportAdapter(@NonNull Context context, ArrayList<POS>sales) {
        super(context, R.layout.categary_row_layout,sales);
        this.context=context;
        this.sales=sales;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.report_row_layout,parent,false);
       TextView cTV= (TextView) view.findViewById(R.id.cTV);
       TextView itemTV= (TextView) view.findViewById(R.id.itemTV);
       TextView priceTV= (TextView) view.findViewById(R.id.priceTV);
       TextView quantityTV= (TextView) view.findViewById(R.id.quantityTV);
       TextView datetimeTV= (TextView) view.findViewById(R.id.dateTimeTV);
        cTV.setText(String.valueOf(sales.get(position).getCategoryID()));
        itemTV.setText(String.valueOf(sales.get(position).getSubCategoryID()));
        quantityTV.setText(String.valueOf(sales.get(position).getQuantity()));
        priceTV.setText(String.valueOf(sales.get(position).getPrice()));
        datetimeTV.setText(sales.get(position).getDatetime());
        return view;
    }
}
