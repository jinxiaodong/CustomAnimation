package com.project.xiaodong.customanimation.chapter3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiaodong.jin on 2018/4/18.
 * description：
 */

public class BallMoveView extends View {

    /**
     * 小球的水平位置
     */
    private int x;
    /**
     * 小球的垂直位置，固定为
     */
    private static final int Y = 100;
    /*
    * 小球的半径
    */
    private static final int RADIUS = 30;
    /**
     * 小球的颜色
     */
    private static final int COLOR = Color.RED;
    private Paint paint;
    /**
     * 移动的方向
     */
    private boolean direction = true;

    public BallMoveView(Context context) {
        this(context, null);
    }

    public BallMoveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BallMoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化画笔，参数表示去锯齿
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(COLOR);
        x = RADIUS;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*画一个小球*/
        canvas.drawCircle(x, Y, RADIUS, paint);
        int width = this.getMeasuredWidth();
        if (x <= RADIUS) {
            direction = true;
        }
        if (x >= width - RADIUS) {
            direction = false;
        }

        x = direction ? x + 15 : x - 15;
    }
}
