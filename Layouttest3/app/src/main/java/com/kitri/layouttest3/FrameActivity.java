package com.kitri.layouttest3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    ImageView smallImg, bigImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        smallImg = findViewById(R.id.small_img);
        bigImg = findViewById(R.id.big_img);

        smallImg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(bigImg.getVisibility()==View.GONE){
                    bigImg.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(FrameActivity.this, android.R.anim.slide_in_left);
                    bigImg.startAnimation(animation);
                }else{
                    bigImg.setVisibility(View.GONE);
                }
                return false;
            }
        });

    }
}
