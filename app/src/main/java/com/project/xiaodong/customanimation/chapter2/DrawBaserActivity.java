package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DrawBaserActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_baser);
        ButterKnife.inject(this);

        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpBuffer);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(200, 10, 300, 300);
        canvas.drawPath(path, paint);

        //画点（ 100， 100），（ 200， 10），（ 300， 300）
        paint.setStrokeWidth(4);
        paint.setColor(Color.RED);
        canvas.drawPoints(new float[]{100, 100, 200, 10, 300, 300}, paint);
        mIv.setImageBitmap(bmpBuffer);
    }
}
