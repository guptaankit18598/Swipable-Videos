package com.swipe.swipablevideos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    float x1, x2, y1, y2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final ViewPager2 videosViewPager = findViewById(R.id.viewPagerVideos);
        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem item3 = new VideoItem();
        item3.videoURL = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video3);
        item3.videoTitle = "Beautiful Nature";
        item3.videoDesc = " Refresh your mind with this Beutiful nature view.";
        videoItems.add(item3);

        VideoItem item1 = new VideoItem();
        item1.videoURL = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1);
        item1.videoTitle = "Beautiful Nature";
        item1.videoDesc = "Refresh your mind with this Beutiful nature view.";
        videoItems.add(item1);

        VideoItem item2 = new VideoItem();
        item2.videoURL = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2);
        item2.videoTitle = "Beautiful Nature";
        item2.videoDesc = "Refresh your mind with this Beutiful nature view.";
        videoItems.add(item2);

        VideoItem item = new VideoItem();
        item.videoURL = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.small);
        item.videoTitle = "Pay with Toy";
        item.videoDesc = " Enjoy the childhood memory.";
        videoItems.add(item);

        videosViewPager.setAdapter(new VideosAdapter(videoItems));
    }

    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
                    //Toast.makeText(this, "right", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SwipeRight.class);
                    startActivity(intent);
                } else if (x1 > x2) {
                    //Toast.makeText(this, "left", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SwipeLeft.class);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }

}