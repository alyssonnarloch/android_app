package com.app.narlocks.android_cronometro;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int count = 0;
    Button start, stop;
    TextView timer;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.timerTextView);
        start = (Button) findViewById(R.id.startButton);
        stop = (Button) findViewById(R.id.stopButton);

        start.setEnabled(true);
        stop.setEnabled(false);

        start.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                handler.post(timedTask);
                start.setEnabled(false);
                stop.setEnabled(true);
            }
        });

        stop.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                handler.removeCallbacks(timedTask);
                start.setEnabled(true);
                stop.setEnabled(false);
                count = 0;

                timer.setText("0");
            }
        });
    }

    private Runnable timedTask = new Runnable() {
        @Override
        public void run() {
            count++;
            timer.setText(String.valueOf(count));
            handler.postDelayed(timedTask, 1000);
        }
    };
}
