package com.app.narlocks.android_grid_view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class AdaptatorImg extends BaseAdapter {

    private Context context;
    private final int[] images;
    private final LayoutParams params;

    public AdaptatorImg(Context context, int[] images, LayoutParams params) {
        this.context = context;
        this.images = images;
        this.params = params;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img = new ImageView(context);
        img.setImageResource(images[position]);
        img.setAdjustViewBounds(true);
        img.setLayoutParams(params);

        return img;
    }
}
