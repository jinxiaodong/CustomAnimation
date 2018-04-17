package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PaintActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        ButterKnife.inject(this);

        /*第一步：创建bitmap，canvas*/
        Bitmap bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        /*第二步创建画笔，绘制文字*/
        Paint paint = new Paint();
        paint.setAntiAlias(true);   //设置抗锯齿
        paint.setStyle(Paint.Style.FILL);   //设置实心样式
        paint.setTextAlign(Paint.Align.LEFT);//设置文本对其方式

        int sp = 24;
        paint.setTextSize(sp);
        paint.setTextSkewX(0.5f);       //设置文字倾斜度
        paint.setUnderlineText(true);   //下划线
        paint.setFakeBoldText(true);     //文本样式，粗体

        canvas.drawText("坚持成就梦想，努力造就人生！",10,100,paint);

        /*绘制图形*/
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#43b9ff"));
        paint.setStrokeWidth(20);
        paint.setStrokeJoin(Paint.Join.BEVEL);
//        paint.setStrokeJoin(Paint.Join.MITER);
//        paint.setStrokeJoin(Paint.Join.ROUND);
        //画矩形
        canvas.drawRect(10,200,350,350,paint);

        /*设置给iv*/
        mIv.setImageBitmap(bitmap);
    }
}
