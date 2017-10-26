package com.example.niloychowdhury.groceryshopmanagement.Controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.niloychowdhury.groceryshopmanagement.R;

import java.util.ArrayList;

/**
 * Created by Niloy Chowdhury on 2017-09-09.
 */

public class SpinnerAdapter extends ArrayAdapter {
    public ArrayList<String>categoryNames;
    public Context context;
    public SpinnerAdapter(@NonNull Context context, ArrayList<String>categoryNames) {
        super(context, R.layout.spinner_layout, categoryNames);
        this.categoryNames=categoryNames;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.spinner_layout,parent,false);
        TextView categoryNameTV= (TextView) view.findViewById(R.id.categoryNameTV);
        categoryNameTV.setText(categoryNames.get(position));
        return view;
    }
}
