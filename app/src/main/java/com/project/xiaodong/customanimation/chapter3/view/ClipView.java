package com.project.xiaodong.customanimation.chapter3.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.project.xiaodong.customanimation.R;

/**
 * Created by xiaodong.jin on 2018/4/19.
 * description：
 */

public class ClipView extends View {

    public ClipView(Context context) {
        this(context, null);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);

        //绘制完整的图片
        canvas.drawBitmap(bitmap, 0, 0, null);

        //平移坐标
        canvas.translate(0, 800);
        //定义裁剪区
        canvas.clipRect(new RectF(100, 100, 500, 500));

        //再次绘制
        canvas.drawBitmap(bitmap, 0, 0, null);


    }
}
