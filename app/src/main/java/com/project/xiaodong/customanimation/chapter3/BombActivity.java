package com.project.xiaodong.customanimation.chapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.BombView;

import java.util.Timer;
import java.util.TimerTask;

public class BombActivity extends AppCompatActivity {

    BombView bomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);
        bomb = findViewById(R.id.bomb);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                bomb.postInvalidate();

            }
        }, 200, 100);
    }
}
