package com.project.xiaodong.customanimation.chapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.LinePathView;

public class ShowlineActivity extends AppCompatActivity {

    LinePathView linepathview;
//    LineView lineview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showline);
        linepathview = findViewById(R.id.linepathview);
//        lineview = findViewById(R.id.lineview);
    }

    //通过path绘制
//    public void onPath(View view) {
//        linepathview.setVisibility(View.VISIBLE);
//        lineview.setVisibility(View.GONE);
//    }
//
//    public void onCanvas(View view) {
//        linepathview.setVisibility(View.GONE);
//        lineview.setVisibility(View.VISIBLE);
//    }
}
