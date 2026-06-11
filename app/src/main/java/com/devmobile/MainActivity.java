package com.devmobile;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    EditText editText;
    Button button;
    ArrayAdapter<String> adapter;
    ArrayList<String> listaQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.list);
        button = findViewById(R.id.button);

        sqldb=openOrCreateDatabase("banco.db", MODE_PRIVATE, null);

        sqldb.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT , titulo TEXT, conteudo TEXT)");

        button.setOnClickListener(view -> {
            String str = editText.getText().toString();
            cv = new ContentValues();
            cv.put("titulo", "X");
            cv.put("conteudo", str);
            sqldb.insert("notas", null, cv );
            listarDB();
        });
        listarDB();
    }

    public void listarDB(){
        Cursor cursor = sqldb.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        listaQuery = new ArrayList<>();
        while(!cursor.isAfterLast()){

            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String conteudo = cursor.getString(cursor.getColumnIndex("conteudo"));
            listaQuery.add("id: " + Integer.toString(id) + " titulo "+  titulo + " conteudo: " + conteudo);
            cursor.moveToNext();
            Log.d("SELECT notas" , "id: " + id + " titulo: " + titulo + " conteudo: " + conteudo);

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaQuery);
            listView.setAdapter(adapter);
        };
    }
}