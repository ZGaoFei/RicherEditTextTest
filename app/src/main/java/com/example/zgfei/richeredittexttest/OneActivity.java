package com.example.zgfei.richeredittexttest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OneActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, OneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }
}
