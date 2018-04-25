package com.project.xiaodong.customanimation.chapter4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiaodong.jin on 2018/4/23.
 * description：
 */

public class ShaderView extends View {

    public ShaderView(Context context) {
        this(context, null);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,paint);
        paint.setShadowLayer(10,1,1, Color.RED);

        canvas.drawText("Android自定义组件",100,100,paint);
        paint.setShadowLayer(10,5,5,Color.BLUE);
        canvas.drawText("Android 绘图阴影",100,220,paint);

    }
}
