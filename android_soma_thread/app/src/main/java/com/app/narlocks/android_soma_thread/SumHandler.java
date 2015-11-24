package com.app.narlocks.android_soma_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class SumHandler extends SumBase{

    protected static final int SUM = 1;

    @Override
    protected void sum(final int n1, final int n2) {
        new Thread() {
            public void run() {
                int sum = n1 + n2;

                Bundle b = new Bundle();
                b.putString("result", String.valueOf(sum));

                Message msg = new Message();
                msg.what = SUM;
                msg.setData(b);

                handler.sendMessage(msg);
            }
        }.start();
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SUM:
                    TextView result = (TextView) findViewById(R.id.resultTextView);
                    String sum = (String) msg.getData().getString("result");

                    result.setText(sum);
                    break;
                default:
                    break;
            }
        }
    };
}
