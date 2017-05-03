package com.example.zgfei.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zgfei.avloading.AnimatorTestActivity;
import com.example.zgfei.avloading.AvLoadingActivity;
import com.example.zgfei.richeredittexttest.OneActivity;
import com.example.zgfei.richeredittexttest.R;

public class MainActivity extends AppCompatActivity {
    private Context context;

    private Button btOne;
    private Button btLoading;
    private Button btAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        btOne = (Button) findViewById(R.id.bt_one);
        btOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/5/2 skip to next activity
                OneActivity.start(context);
            }
        });

        btLoading = (Button) findViewById(R.id.bt_av_loading);
        btLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AvLoadingActivity.start(context);
            }
        });

        btAnimator = (Button) findViewById(R.id.bt_animator_test);
        btAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorTestActivity.start(context);
            }
        });
    }

    private void initData() {
        context = this;
    }
}
