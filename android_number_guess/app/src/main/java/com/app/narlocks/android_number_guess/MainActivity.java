package com.app.narlocks.android_number_guess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randNumber;
    int tries;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();

        randNumber = rand.nextInt(100) + 1;
        System.out.println("Número gerado: " + randNumber);

        tries = 0;
    }

    public void guess(View view) {
        EditText tfNumber = (EditText) findViewById(R.id.tfNumber);
        TextView tvResult = (TextView) findViewById(R.id.tvResult);

        if(tfNumber.length() == 0) {
            Toast msg = Toast.makeText(this, "Forneça um número!", Toast.LENGTH_LONG);
            msg.show();
            return;
        }

        String tip = "";
        int number = Integer.parseInt(tfNumber.getText().toString());
        tries++;

        if(randNumber > number) {
            tip = "Número sorteado é maior!";
        } else if(randNumber < number) {
            tip = "Número sorteado é menor!";
        } else {
            tip = "Acertou!!! Você usou " + tries + " tentativas.";
        }

        tvResult.setText(tip);
    }
}
