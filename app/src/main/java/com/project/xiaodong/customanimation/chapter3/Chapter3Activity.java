package com.project.xiaodong.customanimation.chapter3;

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

public class Chapter3Activity extends AppCompatActivity {
    RecyclerView recycleview;

    private CustomAnimalListAdapter mAdapter;
    List<BeanWraper> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3);
        recycleview = findViewById(R.id.recycleview);

        initData();
    }

    private void initData() {

        mList.add(getBeanWraperData("BallMoveView"));
        mList.add(getBeanWraperData("坐标转换"));
        mList.add(getBeanWraperData("剪切"));
        mList.add(getBeanWraperData("爆炸View"));
        mList.add(getBeanWraperData("手表"));
        mList.add(getBeanWraperData("双缓存"));
        mList.add(getBeanWraperData("双缓存-矩形"));


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
            case "BallMoveView":
                intent = new Intent(this, BallMoveViewActivity.class);
                break;
            case "坐标转换":
                intent = new Intent(this, TranslateXYActivity.class);
                break;
            case "剪切":
                intent = new Intent(this, ClipActivity.class);
                break;
            case "爆炸View":
                intent = new Intent(this, BombActivity.class);
                break;
            case "手表":
                intent = new Intent(this, WatchViewActivity.class);
                break;
            case "双缓存":
                intent = new Intent(this, ShowlineActivity.class);
                break;
            case "双缓存-矩形":
                intent = new Intent(this, DrawRectActivity.class);
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
