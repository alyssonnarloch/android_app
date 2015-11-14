package com.app.narlocks.android_multi_view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void callSecondView(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        EditText ageEditText = (EditText) findViewById(R.id.ageEditText);

        Intent i = new Intent(this, SecondActivity.class);

        Bundle params = new Bundle();

        params.putString("name", nameEditText.getText().toString());

        try {
            params.putInt("age", Integer.parseInt(ageEditText.getText().toString()));
            i.putExtras(params);

            startActivity(i);
            finish();
        } catch(Exception ex) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Informe a idade.", 2);
            toast.show();
        }
    }
}

