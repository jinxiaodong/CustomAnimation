package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/*
*
*
* 绘制椭圆的方法如下：
* public void drawOval(float left, float top, float right, float bottom, Paint paint)
*
* public void drawOval(RectF oval, Paint paint)
* 上面两个方法的参数定义了一个矩形结构， 绘制的结果是该矩形的内切椭圆。
*
* public void drawCircle(float cx, float cy, float radius, Paint paint)
* （ cx、 cy） 为圆心坐标， radius 为圆的半径。
*
*
* 绘制弧线和扇形的方法如下:
*
* public void drawArc(RectF oval, float startAngle,
* float sweepAngle, boolean useCenter, Paint paint)
*
* public void drawArc(float left, float top, float right, float bottom, float startAngle,
* float sweepAngle, boolean useCenter, Paint paint)
*
* 以上两个方法中，参数 startAngle 表示起始角度， sweepAngle 表示扇形或弧线所占的角度，
* 正数表示顺时针， 负数表示逆时针。 useCenter 参数询问是否要使用中心点，
* 为true 表示扇形， 为 false 表示弧线。
* */
public class DrawCircleActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_circle);
        ButterKnife.inject(this);

        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(10, 10, 400, 300);
        paint.setColor(Color.GREEN);
        //画椭圆
        canvas.drawOval(rectF,paint);

        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        //画弧线/扇形：useCenter:true表示画扇形，false表示画弧线
        canvas.drawArc(rectF,-30,-30,true,paint);

        mIv.setImageBitmap(bitmap);
    }
}
