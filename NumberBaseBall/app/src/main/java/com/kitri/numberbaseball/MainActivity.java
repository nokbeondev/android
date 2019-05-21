package com.kitri.numberbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml로 UI 구성한 것을 세팅

        final TextView txtvBoard;
        final EditText edtInput;
        Button btnGo;
        Button btnNewGame;
        Button btnAnswer;
        Button btnClear;
        Button btnClose;

        txtvBoard = findViewById(R.id.txtv_board);
        edtInput = findViewById(R.id.edtxt_input);
        btnGo = findViewById(R.id.btn_go);
        btnNewGame = findViewById(R.id.btn_newgame);
        btnAnswer = findViewById(R.id.btn_answer);
        btnClear = findViewById(R.id.btn_clear);
        btnClose = findViewById(R.id.btn_close);

        final String input = edtInput.getText().toString();


        //txtvBoard.append();

        // GO 버튼 클릭
        btnGo.setOnClickListener(new View.OnClickListener() {

            int gameLength = 3;
            Integer my[];
            Integer com[];
            Random random = new Random();
            int count = 1;

            @Override
            public void onClick(View v) {
                my = new Integer[gameLength];

                for(int i=0; i<gameLength; i++){
                    my[i] = input.charAt(i) - '0';
                }
                int strike = 0;
                int ball = 0;
                for(int c=0;c<gameLength;c++) {
                    for(int m=0;m<gameLength;m++) {
                        if(com[c] == my[m]) {//숫자가 같다면.
                            if(c == m) {//자리수 같다면..
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }
                }
                if(strike == gameLength) {
                    txtvBoard.append(input + "은 정답입니다.\n");
                    txtvBoard.append(count + "번 만에 맞췄네요;;\n");
                    txtvBoard.append("새로운 게임을 시작하세요.\n");
                    edtInput.setVisibility(View.INVISIBLE);
                    count = 1;
                } else {
                    txtvBoard.append(count + "번째 도전 " + input + " : " + strike + "S " + ball + "B\n");
                    count++;
                }
            }
            private boolean isNumber(String myStr) {//1a3
                boolean num = true;
                int len = myStr.length();
                for(int i=0;i<len;i++) {
                    int x = myStr.charAt(i);
                    if(x < 48 || x > 57) {
                        num = false;
                        break;
                    }
                }
                return num;
            }

            //	1. 0 - 9까지의 서로다른 난수
            //	2. 0으로 시작 X
            private void newGame() {
                HashSet<Integer> set = new HashSet<Integer>();
                while(set.size() != gameLength) {
                    set.add(random.nextInt(10));
                }
                com = set.toArray(new Integer[0]);
                txtvBoard.append("*** " + gameLength + "자리 게임을 시작합니다. ***\n");
                edtInput.setVisibility(View.VISIBLE);
            }
        });

        // New Game 버튼 클릭
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
