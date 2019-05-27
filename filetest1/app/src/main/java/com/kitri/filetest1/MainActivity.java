package com.kitri.filetest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btnWrite, btnRead;
    TextView tvFile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = findViewById(R.id.btn_write);
        btnRead = findViewById(R.id.btn_read);
        tvFile = findViewById(R.id.tv_file);

        btnWrite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FileOutputStream fos = null;

                try {
                    fos = openFileOutput("test1.txt", MODE_PRIVATE);// openFileOutput() : 파일을 열겠다는 메소드
                    String str = "안드로이드\n 내장 메모리에\n 글쓰기\n 테스트\n 중입니다.";
                    fos.write(str.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try{
                        if(fos != null){
                            fos.close();
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                BufferedReader in = null;
                try {
//                    fis = openFileInput("test1.txt");
//                    byte b[] = new byte[100];
//                    int x = fis.read(b);
//                    String readTxt = new String(b);


                    in = new BufferedReader(new InputStreamReader(openFileInput("test1.txt")));
                    String readTxt = "";
                    String resultTxt = "";
                    while((readTxt = in.readLine()) != null){
                        resultTxt += readTxt + "\n";
                    }

                    tvFile.setText(resultTxt + "");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try{
                        if(in != null){
                            in.close();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }


            }
        });

    }
}
