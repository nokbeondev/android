package com.kitri.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // 자바의 생성자 역할
    // 전체 Activity에 호출은 생성 시점에 한 번만 호출!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 디자인을 읽어오는 역할
        // 화면 디자인 : activity
        // project >> apk 파일 생성.
        setContentView(R.layout.activity_main);
        Log.i("life"," onCreate() called");

    }

    // 설정한 화면을 액정에 보여줄 준비상태(액정, 응용 프로그램의 연결단계)
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life", " onStart() called");
    }

    //사용자가 실제로 사용할 수 있게 보여주는 상태(foreground 상태)
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life" ,"the onResume() called");
    }

    // 화면을 전환할 작업 준비 단계 - 예를 들어 홈 버튼 누르면 지금까지 정보들 중 저장해야할 것들 스택에 저장하고 홈 화면으로 전환된다.
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life","The onPause() called");
    }

    // 화면이 전환되고 보고 있던 자료 저장.
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life","the onStop() called");
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Life : ", "onRestart() call ~~~");
    }

    // 메모리에서 제거!
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life","the onDestroy() called");
    }




}
