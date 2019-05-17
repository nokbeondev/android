package com.kitri.layouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    Button btnPlus, btnMinus, btnCross, btnDivide, btnClear, btnResult, btnDot;
    Button btnNum[] = new Button[10];
    Integer btnId[] = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};

    TextView resultTv, numTv;
    String num1, num2, resultNum;
    boolean flag, dotFlag;
    int operator;//0 +, 1 -, 2 *, 3 /


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        flag = true;//true : num1, false : num2
        dotFlag = true;

        num1 = "";
        num2 = "";
        resultNum = "";

        int len = btnNum.length;
        for(int i=0;i<len;i++)
            btnNum[i] = findViewById(btnId[i]);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnCross = findViewById(R.id.btn_cross);
        btnDivide = findViewById(R.id.btn_divide);
        btnResult = findViewById(R.id.btn_result);
        btnClear = findViewById(R.id.btn_clear);
        btnDot = findViewById(R.id.btn_dot);

        resultTv = findViewById(R.id.result_tv);
        numTv = findViewById(R.id.num_tv);

//        숫자를 눌렀을 경우.
        for(int i=0;i<len;i++) {
            final int idx;
            idx = i;
            btnNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(flag) {//앞숫자
                        num1 += btnNum[idx].getText().toString();
                        resultNum = num1;
                        numTv.setText(num1);
                    } else {//뒷숫자
                        num2 += btnNum[idx].getText().toString();
                        numTv.setText(num2);
                        resultNum += btnNum[idx].getText().toString();
                    }
                    resultTv.setText(resultNum);
                }
            });
        }

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dotFlag) {
                    String viewNum = "";
                    if(flag) {
                        num1 += ".";
                        viewNum = num1;
                    } else {
                        num2 += ".";
                        viewNum = num2;
                    }
                    numTv.setText(viewNum);
                    resultNum += ".";
                    resultTv.setText(resultNum);
                    dotFlag = false;
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum = num1 + " + ";
                resultTv.setText(resultNum);
                numTv.setText("");
                flag = false;
                dotFlag = true;
                operator = 0;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum = num1 + " - ";
                resultTv.setText(resultNum);
                numTv.setText("");
                flag = false;
                dotFlag = true;
                operator = 1;
            }
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum = num1 + " * ";
                resultTv.setText(resultNum);
                numTv.setText("");
                flag = false;
                dotFlag = true;
                operator = 2;
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum = num1 + " / ";
                resultTv.setText(resultNum);
                numTv.setText("");
                flag = false;
                dotFlag = true;
                operator = 3;
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTv.setText("");
                numTv.setText("");
                flag = true;
                dotFlag = true;
                num1 = "";
                num2 = "";
                resultNum = "";
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = 0.0;
                Double number1 = Double.parseDouble(num1);
                Double number2 = Double.parseDouble(num2);
                switch (operator) {
                    case 0 : {
                        result = number1 + number2;
                    } break;
                    case 1 : {
                        result = number1 - number2;
                    } break;
                    case 2 : {
                        result = number1 * number2;
                    } break;
                    case 3 : {
                        result = number1 / number2;
                    } break;
                }
                resultTv.setText(resultNum + " = " + result + "");
                numTv.setText(result + "");
                num1 = "";
                num2 = "";
            }
        });

    }



}
