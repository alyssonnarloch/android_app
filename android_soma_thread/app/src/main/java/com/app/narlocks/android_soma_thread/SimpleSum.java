package com.app.narlocks.android_soma_thread;

import android.widget.TextView;

public class SimpleSum extends SumBase{
    @Override
    protected void sum(int n1, int n2) {
        int sum = n1 + 2;

        TextView result = (TextView) findViewById(R.id.resultTextView);
        result.setText(String.valueOf(sum));
    }
}
