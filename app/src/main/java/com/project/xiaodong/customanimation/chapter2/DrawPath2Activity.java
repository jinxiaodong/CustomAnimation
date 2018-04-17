package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
/*
* public	void addRect(RectF rect,Path.Direction dir)
* public	void addRect(float left,float top,float right,float bottom,Path.Direction dir)
* 往 Path 对象中添加一个矩形。
*
* public	void addRoundRect(RectF rect,float[]radii,Path.Direction dir)
* public	void addRoundRect(RectF rect,float rx,float ry,Path.Direction dir)
* public	 void addRoundRect(float left,float top,float right,float bottom,float[]radii,Path.Direction dir)
* 往 Path 对象中添加一个圆角矩形。 该方法和前面绘制圆角矩形相比在定义四个角的弧线大小时功能更强， 能对四个角分别定义不同的弧线弧度。
*
* public	void addOval(RectF oval,Path.Direction dir)
* public	void addOval(float left,float top,float right,float bottom,Path.Direction dir)
* 往 Path 对象中添加一个椭圆。
*
* public	void addCircle(float x,float y,float radius,Path.Direction dir)
* 往 Path 对象中添加一个圆。
*
* public	void addArc(RectF oval,float startAngle,float sweepAngle)
* public	 void addArc(float left,float top,float right,float bottom,float startAngle,float sweepAngle)
* 往 Path 对象中添加一段弧。本方法并没有指定方向，因为角度的正负已经代表了方向，
* 正数为顺时针，负数为逆时针。
**/

public class DrawPath2Activity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_path);
        ButterKnife.inject(this);


        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.GREEN);

        Path path = new Path();

        /*矩形
        *  CW 表示顺时针， CCW 表示逆时针
        * */
        path.addRect(10, 10, 300, 100, Path.Direction.CCW);

        /*圆角矩形*/
        path.addRoundRect(new RectF(10, 120, 300, 220),
                new float[]{10, 20, 20, 10, 30, 40, 40, 30}, Path.Direction.CCW);

        /*椭圆*/
        path.addOval(new RectF(10, 240, 300, 340), Path.Direction.CCW);

        //圆
        path.addCircle(60, 390, 50, Path.Direction.CCW);

        //弧线
        path.addArc(new RectF(10, 500, 300, 600), -30, -60);

        canvas.drawPath(path, paint);

        mIv.setImageBitmap(bitmap);
    }
}
