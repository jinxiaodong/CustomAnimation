package com.project.xiaodong.customanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.project.xiaodong.customanimation.chapter2.Chapter2Activity;
import com.project.xiaodong.customanimation.chapter3.Chapter3Activity;
import com.project.xiaodong.customanimation.chapter4.Chapter4Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.recycleview)
    RecyclerView mRecycleview;

    private CustomAnimalListAdapter mAdapter;
    List<BeanWraper> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initData();
    }

    private void initData() {

        mList.add(getBeanWraperData("chapter2"));
        mList.add(getBeanWraperData("chapter3"));
        mList.add(getBeanWraperData("chapter4"));

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
            case "chapter2":
                intent = new Intent(this, Chapter2Activity.class);
                break;
            case "chapter3":
                intent = new Intent(this, Chapter3Activity.class);
                break;case "chapter4":
                intent = new Intent(this, Chapter4Activity.class);
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
