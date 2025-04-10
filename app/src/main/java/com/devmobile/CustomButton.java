package com.devmobile;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomButton extends androidx.appcompat.widget.AppCompatButton {

    float   inicioX,
            inicioY,
            fimX,
            fimY;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Coordenadas" , "X: " + Float.toString(event.getRawX())
        + " Y: " + Float.toString(event.getRawY()));

        int acao=event.getAction();
        switch (event.getAction()){
            case (MotionEvent.ACTION_DOWN):
                inicioX = event.getRawX();
            case (MotionEvent.ACTION_MOVE):
                if(inicioX>event.getRawX()){
                    this.setBackgroundColor(Color.GREEN);
                }
                if(inicioX<event.getRawX()){
                    this.setBackgroundColor(Color.RED);
                }
            default:
        }
        return true;
    }
}
