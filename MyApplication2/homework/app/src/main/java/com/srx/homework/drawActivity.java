package com.srx.homework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class drawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Canvas canvas=new Canvas();
        test(canvas);
    }
    public void test(Canvas canvas){
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawLine(2,2,52,52,paint);
    }
}
