package com.app.narlocks.android_soma_thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public abstract class SumBase extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sum_base);

        Button b = (Button) findViewById(R.id.sumButton);

        b.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText number1 = (EditText) findViewById(R.id.number1EditText);
                EditText number2 = (EditText) findViewById(R.id.number2EditText);

                int n1 = Integer.parseInt(number1.getText().toString());
                int n2 = Integer.parseInt(number2.getText().toString());

                sum(n1, n2);
            }
        });
    }

    protected abstract void sum(int n1, int n2);
}
