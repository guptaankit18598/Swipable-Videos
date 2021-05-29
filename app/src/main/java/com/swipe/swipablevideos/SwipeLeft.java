package com.swipe.swipablevideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SwipeLeft extends AppCompatActivity {
    Button subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_left);
        getSupportActionBar().hide();

        subscribe = findViewById(R.id.subscribe);
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SwipeLeft.this, "Subscribed !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}