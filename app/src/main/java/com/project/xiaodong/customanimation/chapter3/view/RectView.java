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

public class RectView extends View {

    private int firstX, firstY;
    private Path path;
    private Paint paint;
    /*双缓存*/
    private Bitmap bitmapBuffer;
    private Canvas bitmapCanvas;

    public RectView(Context context) {
        this(context, null);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (bitmapBuffer == null) {
            int height = getMeasuredHeight();
            int width = getMeasuredWidth();
            bitmapBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmapBuffer);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmapBuffer, 0, 0, null);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.reset();
                firstX = x;
                firstY = y;
                path.moveTo(firstX, firstY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.reset();
                /*
                * 判断方向：
                *
                * */
                //↘方向
                if (firstX < x && firstY < y) {
                    path.addRect(firstX, firstY, x, y, Path.Direction.CCW);
                }
                //↖方向
                else if (firstX > x && firstY > y) {
                    path.addRect(x, y, firstX, firstY, Path.Direction.CCW);
                }
                //↙方向
                else if (firstX > x && firstY < y) {
                    path.addRect(x, firstY, firstX, y, Path.Direction.CCW);
                }
                //↗方向
                else if (firstX < x && firstY > y) {
                    path.addRect(firstX, y, x, firstY, Path.Direction.CCW);
                }

                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                bitmapCanvas.drawPath(path, paint);
                invalidate();
                break;
        }


        return true;
    }
}
