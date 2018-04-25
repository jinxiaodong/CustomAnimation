package com.project.xiaodong.customanimation.chapter4.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.project.xiaodong.customanimation.R;

/**
 * Created by xiaodong.jin on 2018/4/23.
 * description：
 * <p>
 * Graphics2D 渐变种类有：
 * Ø 线性渐变： LinearGradient
 * Ø 径向渐变： RadialGradient
 * Ø 扫᧿渐变： SweepGradient
 * Ø 位图渐变： BitmapShader
 * Ø 混合渐变： ComposeShader
 */

public class GradientView extends View {

    private static final int OFFSET = 100;
    private Paint mPaint;

    public GradientView(Context context) {
        this(context, null);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int measuredHeight = getMeasuredHeight();
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinearGradientView(canvas);
        RadialGradient(canvas);
        SweepGradient(canvas);
        BitmapShader(canvas);
        ComposeShader(canvas);

    }

    /**
     * 混合渐变： ComposeShader
     *
     * @param canvas
     */
    private void ComposeShader(Canvas canvas) {
        //位图渐变
        Bitmap bmp = BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher);
        BitmapShader bs = new BitmapShader(bmp,
                Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
        //线性渐变
        LinearGradient lg = new LinearGradient(0, 0, getMeasuredWidth(), 0,
                Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        //混合渐变
        ComposeShader cs =
                new ComposeShader(bs, lg, PorterDuff.Mode.SRC_ATOP);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(cs);
        canvas.drawRect(new Rect(0, 0, getMeasuredWidth()-72, 600), paint);
    }

    /**
     * 位图渐变： BitmapShader
     *
     * @param canvas
     */
    private void BitmapShader(Canvas canvas) {
        Bitmap bmp = BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher);
        BitmapShader bs = new BitmapShader(bmp,
                Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(bs);
        int width = bmp.getWidth();
        int i = getMeasuredWidth() / width;
        int left = (getMeasuredWidth() - i * width) / 2;
        canvas.translate(left, 0);
        canvas.drawRect(new Rect(0, 0,
                getMeasuredWidth() -2* left, 800), paint);
        canvas.translate(0, 900);
    }

    /**
     * Ø 扫描渐变： SweepGradient
     *
     * @param canvas
     */
    private void SweepGradient(Canvas canvas) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        SweepGradient sg = new SweepGradient(300, 300,
                new int[]{Color.GREEN, Color.YELLOW, Color.RED, Color.GREEN}, null);
        paint.setShader(sg);
        canvas.drawOval(new RectF(0, 0, 600, 600), paint);
        canvas.translate(0, 700);
    }

    /**
     * 径向渐变： RadialGradient
     *
     * @param canvas
     */
    private void RadialGradient(Canvas canvas) {
        Rect rect = new Rect(0, 100, 400, 500);
        RadialGradient radialGradient = new RadialGradient(200, 300, 200,
                Color.YELLOW, Color.GREEN, Shader.TileMode.MIRROR);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(radialGradient);
        canvas.drawRect(rect, paint);
        canvas.translate(510, 0);
        canvas.drawOval(new RectF(rect), paint);

        canvas.translate(-510, 600);

    }

    /**
     * 线性渐变：
     *
     * @param canvas
     */
    private void LinearGradientView(Canvas canvas) {

        Rect rect = new Rect(100, 100, 500, 400);
        LinearGradient linearGradient = new LinearGradient(rect.left, rect.top, rect.right, rect.bottom,
                Color.RED, Color.GREEN, Shader.TileMode.CLAMP);

        mPaint.setShader(linearGradient);
        canvas.drawRect(rect, mPaint);

        canvas.translate(0, rect.height() + 2 * OFFSET);

        Rect rect1 = new Rect(rect);
        /*放大渐变矩形*/
        rect1.inset(-100, -100);

        LinearGradient linearGradient1 = new LinearGradient(rect1.left, rect1.top, rect1.right, rect1.bottom,
                Color.RED, Color.GREEN, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient1);
        canvas.drawRect(rect1, mPaint);


        canvas.translate(0, rect1.height() + OFFSET);
        //缩小渐变矩形
        Rect rect2 = new Rect(rect1);
        rect2.inset(100, 100);

        LinearGradient linearGradient2 = new LinearGradient(rect2.left, rect2.top, rect2.right, rect2.bottom,
                Color.RED, Color.GREEN, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient2);
        canvas.drawRect(rect1, mPaint);
        canvas.translate(0, rect2.height() + 2 * OFFSET);
    }


}
