package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DrawPathActivity extends AppCompatActivity {

    /*
        * 我们将 Path 的功能归纳成以下几类：
        Ø 往 Path 中添加线条
        Ø 往 Path 中添加矩形、 椭圆、 弧
        Ø 往 Path 中添加曲线和贝塞尔曲线
        Ø 将 Path 中的图形进行运算
        *
        *
        *
        *   public	void	moveTo(float	x,	float	y)
        *   将画笔移动到点（ x， y） 的位置， 使用的是绝对定位。
        *
        *   public	void	rMoveTo(float	dx,	float	dy)
        *   将画笔移动到一个新点， 新点在上一个点的基础上偏移（ dx， dy）,也就是说,
        *   新点的坐标为（ x	+	dx， y	+	dy）。 这里使用的是相对定位。
        *   首字母“r”就是“relative（ 相对） ”的意思。
        *
        *   public	void	lineTo(float	x,	float	y)
        *   将画笔移动到点（ x， y） 的位置，并在上一个点与当前点之前画一条直线。
        *   使用的是绝对定位。
        *
        *   public	void	rLineTo(float	dx,	float	dy)
        *   将画笔移动到一个新点， 新点在上一个点的基础上偏移（ dx， dy），
        *   新点的坐标为（ x	+	dx， y	+	dy）， 同时， 在新点与上一个点之间画一条直线。
        *   这里使用的是相对定位。
        *
         *  public	void	close()
        *   在第一个点和最后一个点之前画一条直线， 形成闭合区域。
        * */


    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_path);
        ButterKnife.inject(this);

        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        Path path = new Path();
        path.moveTo(0, 150);
        path.rLineTo(300, 0);
        path.rLineTo(-300, 150);
        path.rLineTo(150, -300);
        path.rLineTo(150, 300);
        path.close();

        canvas.drawPath(path, paint);

        mIv.setImageBitmap(bitmap);
    }
}
