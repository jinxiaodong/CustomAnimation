package com.project.xiaodong.customanimation.chapter4;

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

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Chapter4Activity extends AppCompatActivity {
    @InjectView(R.id.recycleview)
    RecyclerView mRecycleview;

    private CustomAnimalListAdapter mAdapter;
    List<BeanWraper> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4);
        ButterKnife.inject(this);

        initData();
    }


    private void initData() {
        mList.add(getBeanWraperData("阴影"));
        mList.add(getBeanWraperData("渐变"));
        mList.add(getBeanWraperData("旋转光盘"));
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CustomAnimalListAdapter(this, mList);
        mRecycleview.setAdapter(mAdapter);

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
            case "阴影":
                intent = new Intent(this, ShadowActivity.class);
                break;
            case "渐变":
                intent = new Intent(this, GradientActivity.class);
                break;
            case "旋转光盘":
                intent = new Intent(this, SweepViewActivity.class);
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
