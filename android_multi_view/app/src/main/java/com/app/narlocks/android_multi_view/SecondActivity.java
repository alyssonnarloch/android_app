package com.app.narlocks.android_multi_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();

        if(i != null) {
            Bundle params = i.getExtras();

            if(params != null) {
                String name = params.getString("name");
                int age = params.getInt("age");

                TextView msgTextView = (TextView) findViewById(R.id.msgTextView);
                msgTextView.setText("Bem vindo " + name + " (" + age + " anos)");
            }
        }
    }

    public void callFirstActivity(View view){
        Intent i = new Intent(this, FirstActivity.class);
        startActivity(i);
        finish();
    }
}
