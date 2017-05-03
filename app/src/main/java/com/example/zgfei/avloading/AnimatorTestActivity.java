package com.example.zgfei.avloading;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zgfei.richeredittexttest.R;

import java.util.List;

public class AnimatorTestActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvStart;
    private TextView tvAnimator;

    private ValueAnimator scaleAnim;


    private List<ValueAnimator> list;
    private ValueAnimator alphaAnim;

    public static void start(Context context) {
        Intent intent = new Intent(context, AnimatorTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_test);

        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scaleAnim.cancel();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.iv_animator_test);
        tvAnimator = (TextView) findViewById(R.id.tv_animator_test);
        tvStart = (TextView) findViewById(R.id.tv_start_animator);
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*for (ValueAnimator animator : list) {
                    animator.setObjectValues(imageView);
                    animator.start();
                }*/

                Log.e("===1====", "======");
                scale();
            }
        });

        scale();
    }

    private void scale() {
        scaleAnim = ValueAnimator.ofFloat(1, 0.5f, 1);
        scaleAnim.setTarget(tvAnimator);
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setStartDelay(200);
        scaleAnim.setRepeatMode(ValueAnimator.RESTART);
        scaleAnim.start();

        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });

        scaleAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("=======", "====Start===");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("=======", "====End===");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("=======", "====Cancel===");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("=======", "====Repeat===");
            }
        });
    }

    private ValueAnimator alpha() {
        alphaAnim = ValueAnimator.ofInt(255, 210, 122, 255);
        alphaAnim.setDuration(800);
        alphaAnim.setRepeatCount(-1);
        alphaAnim.setStartDelay(200);

        return alphaAnim;
    }

    private void setValue() {
        Log.e("========", "=======");
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(1000);
        valueAnimator.setTarget(imageView);
        valueAnimator.setRepeatCount(2);// 重复次数
        valueAnimator.setCurrentPlayTime(100);// 延迟播放时间
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);// 播放的模式 RESTART 和 REVERSE
        valueAnimator.start();
    }
}
