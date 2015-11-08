package com.app.narlocks.android_show_text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showText(View view) {
        EditText etInput = (EditText) findViewById(R.id.etInput);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);

        String text = etInput.getText().toString();

        tvResult.setText(text);
    }
}
