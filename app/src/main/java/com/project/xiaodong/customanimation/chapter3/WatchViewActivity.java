package com.project.xiaodong.customanimation.chapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.WatchView;

public class WatchViewActivity extends AppCompatActivity {

    WatchView watchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_view);
        watchview = findViewById(R.id.watchview);
        watchview.run();
    }
}
