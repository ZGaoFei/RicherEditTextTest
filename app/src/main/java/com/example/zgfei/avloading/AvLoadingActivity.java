package com.example.zgfei.avloading;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.zgfei.richeredittexttest.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class AvLoadingActivity extends AppCompatActivity {
    private Button btStop;
    private RecyclerView recyclerView;

    private AvLoadingAdapter adapter;
    private List<String> list;

    public static void start(Context context) {
        Intent intent = new Intent(context, AvLoadingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_av_loading);

        initData();
        initView();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("BallPulseIndicator");
        list.add("BallGridPulseIndicator");
        list.add("BallClipRotateIndicator");
        list.add("BallClipRotatePulseIndicator");

        list.add("SquareSpinIndicator");
        list.add("BallClipRotateMultipleIndicator");
        list.add("BallPulseRiseIndicator");
        list.add("BallRotateIndicator");

        list.add("CubeTransitionIndicator");
        list.add("BallZigZagIndicator");
        list.add("BallZigZagDeflectIndicator");
        list.add("BallTrianglePathIndicator");

        list.add("BallScaleIndicator");
        list.add("LineScaleIndicator");
        list.add("LineScalePartyIndicator");
        list.add("BallScaleMultipleIndicator");

        list.add("BallPulseSyncIndicator");
        list.add("BallBeatIndicator");
        list.add("LineScalePulseOutIndicator");
        list.add("LineScalePulseOutRapidIndicator");

        list.add("BallScaleRippleIndicator");
        list.add("BallScaleRippleMultipleIndicator");
        list.add("BallSpinFadeLoaderIndicator");
        list.add("LineSpinFadeLoaderIndicator");

        list.add("TriangleSkewSpinIndicator");
        list.add("PacmanIndicator");
        list.add("BallGridBeatIndicator");
        list.add("SemiCircleSpinIndicator");

    }

    private void initView() {
        btStop = (Button) findViewById(R.id.bt_stop);
        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < list.size(); i++) {
                    AvLoadingAdapter.ViewHolder viewHolder = (AvLoadingAdapter.ViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
                    viewHolder.view.hide();
                }

                for (String str : list) {
                    Log.e("===str===", "======" + str);
                }
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.av_loading_recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(AvLoadingActivity.this, 4));

        adapter = new AvLoadingAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }
}
