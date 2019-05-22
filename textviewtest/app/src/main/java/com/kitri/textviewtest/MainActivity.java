package com.kitri.textviewtest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tvMsg;

    EditText et;
    Button send;

    String etStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tvMsg = findViewById(R.id.textView4);
        et = findViewById(R.id.et);
        send = findViewById(R.id.send);

        tv1.setTextColor(Color.RED);
        int rgb = Color.rgb(210, 255, 100);
        tv2.setTextColor(rgb);
        tvMsg.setText("MESSAGE");

         send.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 etStr = et.getText().toString();
                 et.setText("");
                 tvMsg.setText(etStr);

             }
         });

    }
}