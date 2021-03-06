package com.kitri.basicapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_id);
        Button btnSend = findViewById(R.id.btn_send_id);
        Button btnCall = findViewById(R.id.btn_call_id);
        Button btnNaver = findViewById(R.id.btn_naver_id);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {// 이벤트 감시자
                Toast.makeText(MainActivity.this, "버튼 클릭했습니다!!!", Toast.LENGTH_SHORT).show();

            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "버튼을 길게 눌렀습니다!!", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent : 데이터 전달 객체

                Intent intent = new Intent(MainActivity.this, TextResultActivity.class); // 전달할 데이터를 intent에 담음
                startActivity(intent); // 담고나서 intent에 담긴 엑티비티(화면) 시작!

            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-3729-3714")); // 전달할 데이터를 intent에 담음
                startActivity(intent); // 담고나서 intent에 담긴 엑티비티(화면) 시작!
            }
        });

        btnNaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com")); // 전달할 데이터를 intent에 담음
                startActivity(intent); // 담고나서 intent에 담긴 엑티비티(화면) 시작!
            }
        });

    }
}
