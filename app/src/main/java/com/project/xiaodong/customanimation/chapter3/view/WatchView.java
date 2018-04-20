package com.project.xiaodong.customanimation.chapter3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaodong.jin on 2018/4/19.
 * description：
 */

public class WatchView extends View {

    private Paint paint;
    private Calendar calendar;

    public WatchView(Context context) {
        this(context, null);
    }

    public WatchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);
        calendar = Calendar.getInstance();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int measuredHeight = this.getMeasuredHeight();
        int measuredWidth = this.getMeasuredWidth();

        //直径
        int len = Math.min(measuredHeight, measuredWidth);

        //绘制表盘
        drawPlate(canvas, len);


        //绘制指针
        drawPoints(canvas, len);


    }

    private void drawPoints(Canvas canvas, int len) {
        calendar.setTimeInMillis(System.currentTimeMillis());
        //获取时分秒
        int hour = calendar.get(Calendar.HOUR) % 12;    //12进制
        int minute = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        //画时针
        int degree = 360 / 12 * hour;
        //转换成弧度
        double radians = Math.toRadians(degree);
        //计算时针的两点坐标，起点：圆心，终点：
        int r = len / 2;
        int startX = r;
        int startY = r;

        int endX = (int) (startX + r * 0.5 * Math.cos(radians));
        int endY = (int) (startY + r * 0.5 * Math.sin(radians));
        canvas.save();
        paint.setStrokeWidth(3);
        //0度是3点，所以逆时针旋转90度开始
        canvas.rotate(-90, r, r);
        //画时针
        canvas.drawLine(startX, startY, endX, endY, paint);
        canvas.restore();


        //画分针
        degree = 360 / 60 * minute;
        radians = Math.toRadians(degree);
        endX = (int) (startX + r * 0.6 * Math.cos(radians));
        endY = (int) (startY + r * 0.6 * Math.sin(radians));
        canvas.save();
        paint.setStrokeWidth(2);
        canvas.rotate(-90, r, r);
        canvas.drawLine(startX, startY, endX, endY, paint);
        canvas.restore();

        //画秒针
        degree = 360 / 60 * seconds;
        radians = Math.toRadians(degree);
        endX = (int) (startX + r * 0.8 * Math.cos(radians));
        endY = (int) (startY + r * 0.8 * Math.sin(radians));
        canvas.save();
        paint.setStrokeWidth(1);
        //0 度从 3 点处开始，时间从 12 点处开始，所以需要将画布旋转 90 度
        canvas.rotate(-90, r, r);
        //画时针
        canvas.drawLine(startX, startY, endX, endY, paint);
        //再给秒针画个“尾巴”
        radians = Math.toRadians(degree - 180);
        endX = (int) (startX + r * 0.15 * Math.cos(radians));
        endY = (int) (startY + r * 0.15 * Math.sin(radians));

        canvas.drawLine(startX, startY, endX, endY, paint);
        canvas.restore();
    }

    private void drawPlate(Canvas canvas, int len) {
        canvas.save();
        int r = len / 2;
        //画圆
        canvas.drawCircle(r, r, r, paint);
        //画刻度
        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                //画一个长刻度
                paint.setColor(Color.RED);
                paint.setStrokeWidth(4);
                canvas.drawLine(19 * r / 10, r, len, r, paint);
                paint.setColor(Color.BLACK);

            } else {
                //短刻度,长刻度占圆半径的 1/15
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(1);
                canvas.drawLine(r + 14 * r / 15, r, len, r, paint);
            }
            //旋转画布
            canvas.rotate(6, r, r);
        }

        //画时间数字
        for (int i = 0; i < 12; i++) {
            Paint mtextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mtextPaint.setTextSize(40);
            mtextPaint.setColor(Color.GRAY);

            int degree = 30 * i - 60;
            double radians = Math.toRadians(degree);
            int x = (int) (r + r * 0.8 * Math.cos(radians));
            int y = (int) (r + r * 0.8 * Math.sin(radians));
            canvas.drawText(i + 1 + "", x - 14, y + 15, mtextPaint);
//            canvas.rotate(30, radius, radius);
        }

    }


    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                postInvalidate();
            }
        }, 0, 1000);
    }
}
