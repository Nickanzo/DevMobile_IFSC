package com.devmobile;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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