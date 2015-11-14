package com.app.narlocks.android_tip_calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double currentTotalBill;
    private int currentCustomPercent;

    private EditText tipTenEditText;
    private EditText tipFifteenEditText;
    private EditText tipTwentyEditText;

    private EditText totalTenEditText;
    private EditText totalFifteenEditText;
    private EditText totalTwentyEditText;

    private EditText billEditText;
    private EditText tipCustomEditText;
    private EditText totalCustomEditText;

    private TextView customTipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipTenEditText = (EditText) findViewById(R.id.tipTenEditText);
        tipFifteenEditText = (EditText) findViewById(R.id.tipFifteenEditText);
        tipTwentyEditText = (EditText) findViewById(R.id.tipTwentyEditText);

        totalTenEditText = (EditText) findViewById(R.id.totalTenEditText);
        totalFifteenEditText = (EditText) findViewById(R.id.totalFifteenEditView);
        totalTwentyEditText = (EditText) findViewById(R.id.totalTwentyEditText);

        billEditText = (EditText) findViewById(R.id.billEditText);
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditTextView);
        totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditText);

        customTipTextView = (TextView) findViewById(R.id.customTipTextView);

        SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);

        currentCustomPercent = customSeekBar.getProgress();

        billEditText.addTextChangedListener(billTextWatcher);

        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
    }

    private TextWatcher billTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private SeekBar.OnSeekBarChangeListener customSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}