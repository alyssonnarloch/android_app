package com.app.narlocks.android_custom_list;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCell extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] soda;
    private final Integer[] imageId;

    public ListCell(Activity context, String[] soda, Integer[] imageId) {
        super(context, R.layout.list_cell , soda);
        this.context = context;
        this.soda = soda;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);

        TextView textTitle = (TextView) rowView.findViewById(R.id.text);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);

        textTitle.setText(soda[position]);
        image.setImageResource(imageId[position]);

        return rowView;
    }
}
