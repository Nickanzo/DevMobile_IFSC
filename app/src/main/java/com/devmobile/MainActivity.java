package com.devmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button buttonA, buttonB;
    FragmentA fragmentA;
    FragmentB fragmentB;

    ListView lv;

    String nomes[] = new String[] {"Damian", "Leo", "Julia"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
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
        buttonA = findViewById(R.id.button);
        buttonB = findViewById(R.id.button2);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.add(R.id.frameLayout, new FragmentA());

        fragmentTransaction.commit();

        buttonA.setOnClickListener(view ->{
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frameLayout, new FragmentA());
            ft.commit();
        });
        buttonB.setOnClickListener(view -> {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frameLayout, new FragmentB());
            ft.commit();
        });

    }
}