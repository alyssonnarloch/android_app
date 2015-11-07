package com.app.narlocks.android_temp_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view) {
        RadioButton rbCelsius = (RadioButton) findViewById(R.id.rbCelsius);
        RadioButton rbFahrenheit = (RadioButton) findViewById(R.id.rbFahrenheit);

        EditText tfTemperature = (EditText) findViewById(R.id.tfTemperature);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);

        if(tfTemperature.length() == 0) {
            Toast.makeText(this, "Forneça uma temperatura válida!", Toast.LENGTH_LONG).show();
            return;
        }

        float temperature = Float.parseFloat(tfTemperature.getText().toString());

        if(rbCelsius.isChecked()) {
            tvResult.setText("Resultado: " + String.valueOf(F2C(temperature)) + "C");
        } else if(rbFahrenheit.isChecked()) {
            tvResult.setText("Resultado: " + String.valueOf(C2F(temperature)) + "F");
        }
    }

    private float F2C(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    private float C2F(float ceusius) {
        return ((ceusius * 9 / 5) + 32);
    }
}
