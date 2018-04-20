package com.project.xiaodong.customanimation.chapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.BallMoveView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BallMoveViewActivity extends AppCompatActivity {

    @InjectView(R.id.ballmoveview)
    BallMoveView mBallmoveview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_move_view);
        ButterKnife.inject(this);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                mBallmoveview.postInvalidate();
            }
        }, 200,20);
    }
}
