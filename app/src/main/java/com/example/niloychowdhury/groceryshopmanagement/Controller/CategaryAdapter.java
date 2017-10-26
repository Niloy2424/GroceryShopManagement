package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.niloychowdhury.groceryshopmanagement.Model.Categary;
import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

/**
 * Created by Niloy Chowdhury on 2017-08-31.
 */

public class CategaryAdapter extends ArrayAdapter<Categary> {
    private Context context;
    private ArrayList<Categary>categaries;
    public CategaryAdapter(@NonNull Context context,  ArrayList<Categary>categories) {
        super(context, R.layout.categary_row_layout,categories);
        this.context=context;
        this.categaries=categories;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.categary_row_layout,parent,false);
        TextView nameTV= (TextView) view.findViewById(R.id.nameTV);
        TextView statusTV= (TextView) view.findViewById(R.id.statusTV);
        nameTV.setText(categaries.get(position).getCategryName());
        statusTV.setText(categaries.get(position).getStatus());
        return view;
    }
}
