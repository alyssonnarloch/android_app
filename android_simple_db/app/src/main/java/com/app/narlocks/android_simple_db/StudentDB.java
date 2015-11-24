package com.app.narlocks.android_simple_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {

    private StudentDBWrapper dbWrapper;
    private SQLiteDatabase db;

    public StudentDB(Context context) {
        dbWrapper = new StudentDBWrapper(context);
    }

    public void open() throws SQLException {
        db = dbWrapper.getWritableDatabase();
    }

    public void close() {
        dbWrapper.close();
    }

    public Student add(String name) {
        ContentValues values = new ContentValues();

        values.put("name", name);

        long newId = db.insert(StudentDBWrapper.TABLE_NAME, null, values);

        Cursor cursor = db.query(StudentDBWrapper.TABLE_NAME, new String[]{"id", "name"}, "id = " + newId, null, null, null, null);

        cursor.moveToFirst();

        Student newStudent = parse(cursor);

        cursor.close();

        return newStudent;
    }

    public void delete(Student student) {
        long id = student.getId();
        db.delete(StudentDBWrapper.TABLE_NAME, "id = " + id, null);
    }

    public List getAll() {
        List students = new ArrayList();

        Cursor cursor = db.query(StudentDBWrapper.TABLE_NAME, new String[]{"id", "name"}, null, null, null, null, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            Student student = parse(cursor);
            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();

        return students;
    }

    private Student parse(Cursor cursor) {
        Student student = new Student();
        student.setId(cursor.getInt(0));
        student.setName(cursor.getString(1));
        return student;
    }
}
