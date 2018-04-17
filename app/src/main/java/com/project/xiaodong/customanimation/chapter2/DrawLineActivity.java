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

/*   public void drawLine ( float startX, float startY, float stopX, float stopY, Paint paint)
 *  在（startX, startY）和（stopX, stopY）两个点之间绘制一条直线。
 *
 *  public void drawLines ( float[] pts, Paint paint)
 *  pts 数组中每 4 个数一组绘制一条直线，多余的元素会忽略。
 *
 *  public void drawLines ( float[] pts, int offset, int count, Paint paint)
 *  从 pts 数组中的 offset 索引处开始，取出 count 个元素，并以 4 个数一组绘制直线，忽略多余的元素
 */
public class DrawLineActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_line);
        ButterKnife.inject(this);

        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bmpBuffer);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);

        final int offsetDy = 50;
        for (int i = 1; i < 6; i++) {
            canvas.drawLine(10, offsetDy * i, 300, offsetDy * i, paint);
        }
        mIv.setImageBitmap(bmpBuffer);

    }
}
