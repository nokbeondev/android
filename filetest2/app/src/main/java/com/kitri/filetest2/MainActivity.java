package com.kitri.filetest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnRead, btnWrite, btnClear;
    EditText etView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btn_read);
        btnClear = findViewById(R.id.btn_clear);
        etView = findViewById(R.id.et_view);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream input = null;
                input = getResources().openRawResource(R.raw.raw_test);

                try {
                    byte txt[] = new byte[input.available()];
                    input.read(txt);
                    etView.setText(new String(txt));

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(input != null){
                            input.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etView.setText("");




            }
        });


    }
}
