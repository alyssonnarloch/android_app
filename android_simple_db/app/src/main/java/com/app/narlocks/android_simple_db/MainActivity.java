package com.app.narlocks.android_simple_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentDB db;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            db = new StudentDB(this);
            db.open();

            List students = db.getAll();

            list = (ListView) findViewById(R.id.list);

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, students);

            list.setAdapter(adapter);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void onResume() {
        try {
            db.open();
            super.onResume();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void onPause() {
        try {
            db.open();
            super.onPause();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void add(View view) {
        ArrayAdapter adapter = (ArrayAdapter) list.getAdapter();

        EditText nameEditText = (EditText) findViewById(R.id.input);
        Student student = db.add(nameEditText.getText().toString());

        adapter.add(student);
    }

    public void deleteFirst(View view) {
        ArrayAdapter adapter = (ArrayAdapter) list.getAdapter();
        Student student = null;

        if(list.getAdapter().getCount() > 0) {
            student = (Student) list.getAdapter().getItem(0);
            db.delete(student);
            adapter.remove(student);
        }
    }
}
