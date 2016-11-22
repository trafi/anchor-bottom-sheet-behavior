package com.trafi.anchorbottomsheetbehavior.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View background = findViewById(R.id.coordinator_layout);
        View.OnClickListener onClickChangeBackgroundColor = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundColor(
                        Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            }
        };

        background.setOnClickListener(onClickChangeBackgroundColor);
        findViewById(R.id.button_the_first).setOnClickListener(onClickChangeBackgroundColor);
        findViewById(R.id.button_the_second).setOnClickListener(onClickChangeBackgroundColor);
        findViewById(R.id.button_the_third).setOnClickListener(onClickChangeBackgroundColor);
    }
}
