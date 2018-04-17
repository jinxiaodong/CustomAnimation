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
/*
      * 点的大小取决于 setStrokeWidth()方法的参数，参数值越大， 点也就越大。
      *
      *  public void drawPoint ( float x, float y, Paint paint)
      * 该方法在（ x， y） 处绘制一个点。
      *
      * public void drawPoints ( float[] pts, Paint paint)
      * 该方法的参数 pts 是一个数组，从下标 0 开始每 2 个数确定一个点， 连续绘制多个点。多余的元素会忽略。
      *
      *  public void drawPoints ( float[] pts, int offset, int count, Paint paint)
      * 从 pts 数组中的第 offset 处开始取出 count 个数字， 以 2 个数为一组确实一个点， 连
      * 续绘制若干个点。 忽略多余的元素。
      * */
public class DrawPointActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_point);
        ButterKnife.inject(this);

        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        //画一个红点
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        canvas.drawPoint(120,20,paint);
        //画一组绿点
        paint.setColor(Color.GREEN);
        float[] points = {10, 10, 50, 50, 50, 100, 50, 150};
        canvas.drawPoints(points,paint);

        mIv.setImageBitmap(bitmap);
    }
}
