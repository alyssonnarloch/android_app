package com.app.narlocks.android_soma_thread;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] mStrings = new String[] {
            "Activity de Soma", "Activity com Thread", "Activity com Thread Handler", "Sair"
        };

        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch(position) {
            case 0:
                startActivity(new Intent(this, SimpleSum.class));
                break;
            case 1:
                startActivity(new Intent(this, SumThread.class));
                break;
            case 2:
                startActivity(new Intent(this, SumHandler.class));
            default:
                finish();
        }
    }
}
