package com.project.xiaodong.customanimation.chapter2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/*
*
* 绘制矩形时， 参数分为两种： 一种是指定 left、 top、 right、 bottom 等 4 个参数，
* 另一种直接指定一个 Rect 对象或 RectF 对象。
*
* public void drawRect(float left, float top, float right, float bottom, Paint paint)
*
* public void drawRect(Rect r, Paint paint)
*
* public void drawRect(RectF r, Paint paint)
*
*
*
* 绘制圆角矩形一共有 2 个重载的方法：
*
* public void drawRoundRect(float left, float top, float right, float bottom,
* float rx, float ry, Paint paint)
* 该方法用于绘制一个圆角矩形， left、 top、 right、 bottom 构建一个矩形，
* rx、 ry 分别是圆角处的水平半径和垂直半径。rx 和 ry 不一定相同， 如果不同， 则是椭圆上的一段弧线。
*
* public void drawRoundRect(RectF rect, float rx, float ry, Paint paint)
* 该方法是上面方法的另一种重载形式
*
* */
public class RrawRectActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rraw_rect);
        ButterKnife.inject(this);

        /*第一步：创建bitmap，canvas*/
        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        /*第二步创建画笔，绘制文字*/
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawRoundRect(10, 10, 400, 300, 50, 30, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(10, 320, 400, 620, 30, 50, paint);

        mIv.setImageBitmap(bitmap);


    }
}
