package com.project.xiaodong.customanimation.chapter3.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xiaodong.jin on 2018/4/20.
 * description：
 */

public class LinePathView extends View {

    private int preX;
    private int preY;


    /*Bitmap缓存区*/
    private Bitmap bitmapBuffer;
    private Canvas bitmapCanvas;
    private Paint mPaint;
    private Path mPath;

    public LinePathView(Context context) {
        this(context, null);
    }

    public LinePathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinePathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPath = new Path();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (bitmapBuffer == null) {
            int width = this.getMeasuredWidth();
            int height = this.getMeasuredHeight();
            bitmapBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmapBuffer);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmapBuffer, 0, 0, null);
        canvas.drawPath(mPath, mPaint);
    }

    /*
    *
    * 我们在画曲线时， 使用了 Path 类的 quadTo()方法， 该方法能绘制出相对平滑的贝塞尔曲线，
    但是控制点和起点使用了同一个点， 这样效果不是很理想。 现ᨀ供一种计算控制点的方法， 假如
    起点坐标为（ x1， y1）， 终点坐标为（ x2， y2），控制点坐标即为（（ x1	+	x2） /	2，（ y1	+	y2） /	2）。
    * */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();

                preX = x;
                preY = y;

                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                //手指移动过程中只显示绘制过程
                //使用贝塞尔曲线进行绘图，需要一个起点（ preX,preY）
                //一个终点（ x,	y），一个控制点((preX	+	x)/2,	(preY	+	y)	/	2))
                int controlX = (x + preX) / 2;
                int controlY = (y + preY) / 2;
                mPath.quadTo(controlX, controlY, x, y);
                invalidate();
                preX = x;
                preY = y;
                break;

            case MotionEvent.ACTION_UP:
                //手指松开后将最终的绘图结果绘制在 bitmapBuffer 中，同时绘制到 View 上
                bitmapCanvas.drawPath(mPath, mPaint);
                invalidate();
                break;

        }

        return true;
    }


}
