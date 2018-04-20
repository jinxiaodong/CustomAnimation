package com.project.xiaodong.customanimation.chapter3.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.project.xiaodong.customanimation.R;

/**
 * Created by xiaodong.jin on 2018/4/19.
 * description：
 */

public class BombView extends View {

    private int index = 0;  //显示第几张小图
    private Bitmap mBitmap;

    public BombView(Context context) {
        this(context, null);
    }

    public BombView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BombView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bomb);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int height = mBitmap.getHeight();
        int width = mBitmap.getWidth();

        //剪切小图的宽
        int frameWidth = width / 7;
        Rect rect = new Rect(0, 0, frameWidth, height);
        canvas.save();
        canvas.translate(100, 100);
        canvas.clipRect(rect);
        canvas.drawBitmap(mBitmap, -index * frameWidth, 0, null);
        canvas.restore();
        index++;
        if (index == 7) {
            index = 0;
        }
    }
}
