package com.trafi.anchorbottomsheetbehavior.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trafi.anchorbottomsheetbehavior.BottomSheetUtils;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View background = findViewById(R.id.coordinator_layout);
        final View.OnClickListener onClickChangeBackgroundColor = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundColor(
                        Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            }
        };

        ViewPager2 pager = findViewById(R.id.pager);
        BottomSheetUtils.setupViewPager2(pager);

        pager.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(LayoutInflater.from(getApplicationContext()).inflate(R.layout.viewpager_page_layout, parent, false)) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                holder.itemView.findViewById(R.id.button_the_first).setOnClickListener(onClickChangeBackgroundColor);
                holder.itemView.findViewById(R.id.button_the_second).setOnClickListener(onClickChangeBackgroundColor);
                holder.itemView.findViewById(R.id.button_the_third).setOnClickListener(onClickChangeBackgroundColor);
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        background.setOnClickListener(onClickChangeBackgroundColor);
    }
}
