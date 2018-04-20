package com.project.xiaodong.customanimation.chapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.xiaodong.customanimation.R;
import com.project.xiaodong.customanimation.chapter3.view.CoordinateView;

public class TranslateXYActivity extends AppCompatActivity {

    CoordinateView coordinateview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_xy);
        coordinateview = findViewById(R.id.coordinateview);

        
    }
}
