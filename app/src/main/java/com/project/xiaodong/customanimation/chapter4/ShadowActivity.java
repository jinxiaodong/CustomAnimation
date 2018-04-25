package com.project.xiaodong.customanimation.chapter4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.BallMoveView;
import com.project.xiaodong.customanimation.chapter4.view.ShaderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShadowActivity extends AppCompatActivity {


    List<View> views = new ArrayList<>();
    @InjectView(R.id.shaderview)
    ShaderView mShaderview;
    @InjectView(R.id.ballview)
    BallMoveView mBallview;


    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
        ButterKnife.inject(this);
        views.add(mShaderview);
        views.add(mBallview);


    }

    public void next(View view) {
        views.get(currentIndex).setVisibility(View.GONE);
        if (++currentIndex >= views.size()) {
            currentIndex = 0;
        }
        views.get(currentIndex).setVisibility(View.VISIBLE);
    }
}
