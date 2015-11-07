package com.app.narlocks.android_churrascometro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar sbMenNumber = (SeekBar) findViewById(R.id.sbMenNumber);
        final TextView tvMenNumber = (TextView) findViewById(R.id.tvMenNumber);

        final SeekBar sbWemenNumber = (SeekBar) findViewById(R.id.sbWemenNumber);
        final TextView tvWemenNumber = (TextView) findViewById(R.id.tvWemenNumber);

        final SeekBar sbChildrenNumber = (SeekBar) findViewById(R.id.sbChildrenNumber);
        final TextView tvChildrenNumber = (TextView) findViewById(R.id.tvChildrenNumber);

        sbMenNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvMenNumber.setText(String.valueOf(progress));
                calculate(progress, sbWemenNumber.getProgress(), sbChildrenNumber.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbWemenNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvWemenNumber.setText(String.valueOf(progress));
                calculate(sbMenNumber.getProgress(), progress, sbChildrenNumber.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbChildrenNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvChildrenNumber.setText(String.valueOf(progress));
                calculate(sbMenNumber.getProgress(), sbWemenNumber.getProgress(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculate(int nMen, int nWemen, int nChildren) {
        int totalSausage, totalMeat;
        float resultSausage, resultMeat;

        TextView tvResultSausage = (TextView) findViewById(R.id.tvResultSausage);
        TextView tvResultMeat = (TextView) findViewById(R.id.tvResultMeat);

        totalSausage = nMen * 450 + nWemen * 250 + nChildren * 200;
        resultSausage = (float) totalSausage / 1000;

        totalMeat = nMen * 500 + nWemen * 300 + nChildren * 200;
        resultMeat = (float) totalMeat / 1000;

        tvResultSausage.setText("Linguiça: " + String.valueOf(resultSausage));
        tvResultMeat.setText("Carne: " + String.valueOf(resultMeat));
    }
}
