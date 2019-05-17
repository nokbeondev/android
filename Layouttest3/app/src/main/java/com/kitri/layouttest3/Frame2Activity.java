package com.kitri.layouttest3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DigitalClock;
import android.widget.ImageView;

public class Frame2Activity extends AppCompatActivity {

    Button btn, btn2, btn3;
    AnalogClock analogClock;
    DigitalClock digitalClock;
    CalendarView calendarView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame2);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        analogClock = findViewById(R.id.analog);
        digitalClock = findViewById(R.id.digital);
        calendarView = findViewById(R.id.calendar);
        imageView = findViewById(R.id.logo);

        imageView.setVisibility(View.VISIBLE);
        analogClock.setVisibility(View.GONE);
        digitalClock.setVisibility(View.GONE);
        calendarView.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView.getVisibility()==View.VISIBLE){
                    imageView.setVisibility(View.GONE);
                }
                if(digitalClock.getVisibility()==View.VISIBLE){
                    digitalClock.setVisibility(View.GONE);
                }
                if(calendarView.getVisibility()==View.VISIBLE){
                    calendarView.setVisibility(View.GONE);
                }
                if(analogClock.getVisibility()==View.GONE){
                    analogClock.setVisibility(View.VISIBLE);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView.getVisibility()==View.VISIBLE){
                    imageView.setVisibility(View.GONE);
                }
                if(analogClock.getVisibility()==View.VISIBLE){
                    analogClock.setVisibility(View.GONE);
                }
                if(calendarView.getVisibility()==View.VISIBLE){
                    calendarView.setVisibility(View.GONE);
                }
                if(digitalClock.getVisibility()==View.GONE){
                    digitalClock.setVisibility(View.VISIBLE);
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView.getVisibility()==View.VISIBLE){
                    imageView.setVisibility(View.GONE);
                }
                if(analogClock.getVisibility()==View.VISIBLE){
                    analogClock.setVisibility(View.GONE);
                }
                if(digitalClock.getVisibility()==View.VISIBLE){
                    digitalClock.setVisibility(View.GONE);
                }
                if(calendarView.getVisibility()==View.GONE){
                    calendarView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
