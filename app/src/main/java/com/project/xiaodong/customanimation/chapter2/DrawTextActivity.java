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

/*
* 从指定的位置（坐标）开始绘制文字:
* public void drawText(char[] text, int index, int count, float x, float y, Paint paint)
*
* public void drawText(String text, float x, float y, Paint paint)
*
* public void drawText(String text, int start, int end, float x, float y, Paint paint)
*
* public void drawText(CharSequence text, int start, int end, float x, float y, Paint paint)
*   参数 index 和
*   count、 start 和 end 可以从字符串中取出子串， 而参数 x、 y 就是文字绘制的坐标位置，
*   其中 y 是文字的 baseline 的值
*
* 沿着 Path 定义好的路径绘制文字:
*
* public void drawTextOnPath(String text, Path path, float hOffset, float vOffset,
* Paint paint)
*
* public void drawTextOnPath(char[] text, int index, int count,
* Path path, float hOffset, float vOffset, Paint paint)
*   参数 hOffset 和 vOffset 用
*   于定义文字离 Path 的水平偏移量和垂直偏移量， 正数和负数影响文字与路径的相对位
*   置。 同样的， 也支持绘制从字符数组中截取的子串， index 表示起始索引， count 表示
*   要截取的长度。
* */
public class DrawTextActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_text);
        ButterKnife.inject(this);

        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(24);
        String text = "乘风破浪会有时，直挂云帆济沧海！";
        canvas.drawText(text, 10, 50, paint);
        canvas.drawText(text, 0, 5, 10, 100, paint);
        canvas.drawText(text.toCharArray(), 5, text.length() - 5, 10, 150, paint);

        Path path = new Path();
        path.moveTo(10, 200);
        path.quadTo(100, 100, 300, 300);
        canvas.drawTextOnPath(text, path, 15, 15, paint);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        mIv.setImageBitmap(bitmap);
    }
}
