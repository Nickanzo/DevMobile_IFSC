package com.devmobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimplePaint extends View {

    Path currentPath;
    Paint currentPaint;

    public SimplePaint(Context context) {
        super(context);
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SimplePaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init(){
    currentPaint = new Paint();
    currentPath = new Path();

    currentPaint.setColor(Color.BLACK);
    currentPaint.setStrokeWidth(10);
    currentPaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float   x0,
                y0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x0=event.getX();
                y0=event.getY();
                currentPath.moveTo(x0,y0);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(event.getRawX(), event.getRawY());
                this.invalidate();
                return true;

            default:
                return true;
        }
    }

    public void clearDraw(){
        currentPath.reset();
        invalidate();
    }
}
