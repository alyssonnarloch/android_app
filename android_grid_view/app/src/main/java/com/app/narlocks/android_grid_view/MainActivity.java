package com.app.narlocks.android_grid_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] images = {
            R.drawable.smile1, R.drawable.smile2, R.drawable.smile1,
            R.drawable.smile2, R.drawable.smile1, R.drawable.smile2,
            R.drawable.smile1, R.drawable.smile2, R.drawable.smile1,
            R.drawable.smile2, R.drawable.smile1, R.drawable.smile2,
            R.drawable.smile1, R.drawable.smile2, R.drawable.smile1,
            R.drawable.smile2, R.drawable.smile1, R.drawable.smile2,
            R.drawable.smile1, R.drawable.smile2, R.drawable.smile1,
            R.drawable.smile2, R.drawable.smile1, R.drawable.smile2,
            R.drawable.smile1, R.drawable.smile2, R.drawable.smile1,
            R.drawable.smile2, R.drawable.smile1, R.drawable.smile2,
            R.drawable.smile1, R.drawable.smile2, R.drawable.smile1,
            R.drawable.smile2, R.drawable.smile1, R.drawable.smile2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView) findViewById(R.id.gridView);
        grid.setAdapter(new AdaptatorImg(this, images, new GridView.LayoutParams(30, 30)));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Imagem selecionada: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
