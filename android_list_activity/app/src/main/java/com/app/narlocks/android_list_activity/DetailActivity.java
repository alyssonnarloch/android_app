package com.app.narlocks.android_list_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);

        if(i != null) {
            Bundle params = i.getExtras();
            if(params != null) {
                nameTextView.setText(String.valueOf(params.getLong("id") + " - " + params.getString("name")));
            }
        }
    }
}
