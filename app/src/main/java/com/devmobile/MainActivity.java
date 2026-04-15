 package com.devmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

 public class MainActivity extends AppCompatActivity {

    int[] imagens = new int[] {R.drawable.cachorro, R.drawable.gardem,
             R.drawable.happy, R.drawable.patinho, R.drawable.porquinho};
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setTitle("Sorteio");
        setContentView(R.layout.activity_main);

        Button btAnt = findViewById(R.id.btAnt);
        Button btProx = findViewById(R.id.btProx);
        ImageView img = findViewById(R.id.imageView);
        img.setImageResource(imagens[pos]);

        btAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos != 0)
                    pos--;
                img.setImageResource(imagens[pos]);
            }
        });
        btProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( pos < ( imagens.length - 1))
                    pos++;
                img.setImageResource(imagens[pos]);
            }
        });
    }
}