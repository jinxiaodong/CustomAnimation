package com.project.xiaodong.customanimation.chapter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.project.xiaodong.customanimation.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DrawBaserActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_baser);
        ButterKnife.inject(this);


    }


    public void showBaser(View view) {
        /*
        * moveTo()方法定义起点，
        * 再调用 public void quadTo(float x1, float y1, float x2, float y2)方法绘制贝塞尔曲线，
        * 其中，（ x1， y1） 是控制点，（ x2， y2） 是终点
        * */
        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpBuffer);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(200, 10, 300, 300);
        canvas.drawPath(path, paint);

        //画点（ 100， 100），（ 200， 10），（ 300， 300）
        paint.setStrokeWidth(4);
        paint.setColor(Color.RED);
        canvas.drawPoints(new float[]{100, 100, 200, 10, 300, 300}, paint);
        mIv.setImageBitmap(bmpBuffer);
    }

    public void showArtTo(View view) {

        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpBuffer);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100, 100);
        /*
        * 参数 forceMoveTo 为 true 时，表示开始一个新的图形，不和上一个点进行连接， 为 false 时才和上一个点连接。
        * */
        path.arcTo(new RectF(100, 150, 300, 300), -30, 60, false);
        canvas.drawPath(path, paint);
        mIv.setImageBitmap(bmpBuffer);

    }

    public void showOperatNO(View view) {
        /*
        * Path.Op.	DIFFERENCE
        * 差集， 图形 A 减去与图形 B 重叠的区域后 A 余下的区域。
        * Path.Op. INTERSECT
        * 交集， 图形 A 和图形 B 的重叠区域。
        * Path.Op. REVERSE_DIFFERENCE
        * 反差集， 图形 B 减去与图形 A 重叠的区域后 B 余下的区域。
        * Path.Op. UNION
        * 并集， 包含了图形 A 和图形 B 的所有区域。
        * Path.Op.XOR
        * 补集， 即图形 A 和图形 B 的所有区域减去他们的重叠区域后余下的区域
        * */

        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpBuffer);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.addRect(new RectF(10, 10, 110, 110), Path.Direction.CCW);
        Path path2 = new Path();
        path2.addCircle(100, 100, 50, Path.Direction.CCW);
        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);
        canvas.drawPath(path2, paint);

        mIv.setImageBitmap(bmpBuffer);
    }

    public void showOperatYes(View view) {
        /*
        * Path.Op.	DIFFERENCE
        * 差集， 图形 A 减去与图形 B 重叠的区域后 A 余下的区域。
        * Path.Op. INTERSECT
        * 交集， 图形 A 和图形 B 的重叠区域。
        * Path.Op. REVERSE_DIFFERENCE
        * 反差集， 图形 B 减去与图形 A 重叠的区域后 B 余下的区域。
        * Path.Op. UNION
        * 并集， 包含了图形 A 和图形 B 的所有区域。
        * Path.Op.XOR
        * 补集， 即图形 A 和图形 B 的所有区域减去他们的重叠区域后余下的区域
        * */

        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpBuffer);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);  //修改这里查看不同效果
        Path path = new Path();
        path.addRect(new RectF(10, 10, 110, 110), Path.Direction.CCW);
        Path path2 = new Path();
        path2.addCircle(100, 100, 50, Path.Direction.CCW);
        path.op(path2, Path.Op.DIFFERENCE); //修改这里查看不同效果
        canvas.drawPath(path, paint);
//        paint.setColor(Color.RED);
//        canvas.drawPath(path2, paint);

        mIv.setImageBitmap(bmpBuffer);
    }
}
