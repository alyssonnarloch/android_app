package com.app.narlocks.android_list_activity;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] items = new String[] {"Drink 1", "Drink 2", "Drink 3", "Drink 4", "Drink 5"};

        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        setListAdapter(array);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object obj = this.getListAdapter().getItem(position);
        String item = obj.toString();

        Intent i = new Intent(this, DetailActivity.class);
        Bundle params = new Bundle();

        params.putLong("id", id);
        params.putString("name", item);

        i.putExtras(params);

        startActivity(i);

        //Toast.makeText(this, "Item " + item, Toast.LENGTH_LONG).show();
    }
}
