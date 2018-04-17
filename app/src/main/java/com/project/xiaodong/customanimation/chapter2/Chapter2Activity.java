package com.project.xiaodong.customanimation.chapter2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.xiaodong.customanimation.BeanWraper;
import com.project.xiaodong.customanimation.CustomAnimalListAdapter;
import com.project.xiaodong.customanimation.R;

import java.util.ArrayList;
import java.util.List;

public class Chapter2Activity extends AppCompatActivity {

    RecyclerView recycleview;

    private CustomAnimalListAdapter mAdapter;
    List<BeanWraper> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);
        recycleview = findViewById(R.id.recycleview);

        initData();

    }

    private void initData() {

        mList.add(getBeanWraperData("Paint"));
        mList.add(getBeanWraperData("位图"));
        mList.add(getBeanWraperData("绘制点"));
        mList.add(getBeanWraperData("绘制线"));
        mList.add(getBeanWraperData("绘制矩形"));

        recycleview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CustomAnimalListAdapter(this, mList);
        recycleview.setAdapter(mAdapter);

        mAdapter.setOnButtonClick(new CustomAnimalListAdapter.onButtonClick() {
            @Override
            public void onBtnClick(View view, int position) {
                JumpToActivity(mList.get(position).name);
            }
        });
    }

    private void JumpToActivity(String name) {
        Intent intent = null;
        switch (name) {
            case "Paint":
                intent = new Intent(this, PaintActivity.class);
                break;
            case "位图":
                intent = new Intent(this, DrawBitmapActivity.class);
                break;
            case "绘制点":
                intent = new Intent(this, DrawPointActivity.class);
                break;
            case "绘制线":
                intent = new Intent(this, DrawLineActivity.class);
                break;
            case "绘制矩形":
                intent = new Intent(this, RrawRectActivity.class);
                break;
        }
        if (intent == null) {
            return;
        }
        startActivity(intent);
    }


    private BeanWraper getBeanWraperData(String name) {
        BeanWraper beanWraper = new BeanWraper();
        beanWraper.name = name;
        return beanWraper;
    }
}
