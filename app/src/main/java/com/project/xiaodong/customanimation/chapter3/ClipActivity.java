package com.project.xiaodong.customanimation.chapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.ClipOpView;
import com.project.xiaodong.customanimation.chapter3.view.ClipView;

public class ClipActivity extends AppCompatActivity {

    ClipView clipview;
    ClipOpView clipopview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);
        clipview = findViewById(R.id.clipview);
        clipopview = findViewById(R.id.clipopview);
    }

    public void showViewNOOP(View view) {
        clipopview.setVisibility(View.INVISIBLE);
        clipview.setVisibility(View.VISIBLE);
    }

    public void showViewOP(View view) {
        clipopview.setVisibility(View.VISIBLE);
        clipview.setVisibility(View.INVISIBLE);
    }
}
