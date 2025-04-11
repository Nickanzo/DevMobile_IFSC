package com.devmobile;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.skydoves.colorpicker.compose.ColorPickerController;

public class MainActivity extends AppCompatActivity {

    Button buttonClear;
    SimplePaint simplePaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonClear=findViewById(R.id.buttonClear);
        simplePaint=findViewById(R.id.simplePaint);

        buttonClear.setOnClickListener(v -> {

        });
    }
}