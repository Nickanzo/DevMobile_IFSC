package com.devmobile;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqldb;
    ContentValues cv;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        sqldb=openOrCreateDatabase("banco.db", MODE_PRIVATE, null);

        sqldb.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT , titulo TEXT, conteudo TEXT)");

        //cv.put("id", 1);
        cv.put("titulo", "Nota 1");
        cv.put("conteudo", "Conteudo da nota 1");

        sqldb.insert("notas", null, cv );


        Cursor cursor = sqldb.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        ArrayList<String> listaQuery = new ArrayList<>();
        while(!cursor.isAfterLast()){

            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            @SuppressLint("Range") String conteudo = cursor.getString(cursor.getColumnIndex("conteudo"));

            cursor.moveToNext();
            Log.d("SELECT notas" , "id: " + id + " titulo: " + titulo + " conteudo: " + conteudo);
            listaQuery.add("id: " + Integer.toString(id) + " titulo "+  titulo + " conteudo: " + conteudo);

        };


    }
}