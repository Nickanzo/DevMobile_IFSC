package com.devmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String nomes[] = new String[] {"Damian", "Leo", "Julia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                nomes
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener( (parent, view, position, id) -> {
            Toast.makeText(this, nomes[position], Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), ExibeDados.class);
            i.putExtra("user" , nomes[position]);
            startActivity(i);
        });
    }
}