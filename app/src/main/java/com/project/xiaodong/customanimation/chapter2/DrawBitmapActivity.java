package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DrawBitmapActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_bitmap);
        ButterKnife.inject(this);

        /*
        *
        *
        *   public void drawBitmap(Bitmap bitmap, float	left, float	top, Paint	paint)
        *  该方法是最为简单， 将 bitmap 绘制在画布上， 同时指定位图左上角相对于画布的坐标， 大小与原位置相同， 不进行任何缩放。
        *  绘制位图时， 除非需要进行位图运算，否则， 并不需要指定 paint 对象， 直接传递null 即可。
        *
        *  public void drawBitmap(Bitmap bitmap, Rect src, Rect dst,Paint paint)
        *
        *  public void drawBitmap(Bitmap bitmap, Rect src, RectF dst, Paint	paint)
        *  这两个方法从 bitmap 中抠出一块大小区域为 src 的图片并绘制到 canvas 的 dst 处。src
        *  和 dst 的大小与比例关系影响到最终的绘制效果
        *
        * */
        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Bitmap ivBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        /*原图大小绘制*/
        canvas.drawBitmap(ivBitmap, 0, 0, null);

        int width = ivBitmap.getWidth();
        int height = ivBitmap.getHeight();

        Rect src = new Rect(0, 0, width, height);
        Rect dst = new Rect(0, height, width * 3, height * 3 + height);
        /*放大三倍*/
        canvas.drawBitmap(ivBitmap, src, dst, null);

        mIv.setImageBitmap(bitmap);
    }
}
