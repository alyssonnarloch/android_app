package com.app.narlocks.android_gorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    float billValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sbTip = (SeekBar) findViewById(R.id.sbTip);

        sbTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView tvTipResult = (TextView) findViewById(R.id.tvTipResult);
                tvTipResult.setText(String.valueOf(progress).toString() + "%");

                calculateTip(getBillValue(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public float getBillValue() {
        EditText etBillValue = (EditText) findViewById(R.id.etBillValue);

        String billInputValue = etBillValue.getText().toString();

        if(billInputValue.length() == 0) {
            billValue = 0;
        } else {
            billValue = Float.parseFloat(billInputValue);
        }

        return billValue;
    }

    public void calculateByButton(View view) {
        RadioButton rbTen = (RadioButton) findViewById(R.id.rbTen);
        RadioButton rbFifty = (RadioButton) findViewById(R.id.rbFifty);
        RadioButton rbTwenty = (RadioButton) findViewById(R.id.rbTwenty);

        if(rbTen.isChecked()) {
            calculateTip(getBillValue(), 10);
        } else if (rbFifty.isChecked()) {
            calculateTip(getBillValue(), 15);
        } else if (rbTwenty.isChecked()) {
            calculateTip(getBillValue(), 20);
        }
    }

    public void calculateTip(float billValue, int tipPercentage) {
        TextView tvBillResult = (TextView) findViewById(R.id.tvBillResult);
        float tipPercentageFloat = (float) tipPercentage;
        float tipValue = (tipPercentageFloat / 100) * billValue;

        tvBillResult.setText(formatMoney(tipValue));
    }

    public String formatMoney(float value) {
        NumberFormat nFormat = NumberFormat.getCurrencyInstance();
        return nFormat.format(value);
    }
}
