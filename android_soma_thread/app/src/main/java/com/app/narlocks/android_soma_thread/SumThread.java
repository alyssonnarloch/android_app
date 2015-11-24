package com.app.narlocks.android_soma_thread;

import android.widget.TextView;

public class SumThread extends SumBase {
    @Override
    protected void sum(final int n1, final int n2) {
        new Thread() {
            public void run() {
                int sum = n1 + n2;

                TextView result = (TextView) findViewById(R.id.resultTextView);
                result.setText(String.valueOf(sum));
            }
        }.start();
    }
}
