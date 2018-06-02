package com.example.asus.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Pre1=1, Pre2=1, Last;
    TextView Txt;
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        Txt = (TextView) findViewById(R.id.textView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.isEnabled()==true){
                    btn1.setText(String.valueOf(Pre2));
                    btn1.setEnabled(false);
                    btn2.setEnabled(true);
                    Txt.setText(Txt.getText()+","+Pre1);
                    Last=Pre1;
                    Pre1=Pre2;
                    Pre2+=Last;
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn2.isEnabled()==true){
                    btn2.setText(String.valueOf(Pre2));
                    btn2.setEnabled(false);
                    btn1.setEnabled(true);
                    Txt.setText(Txt.getText()+","+Pre1);
                    Last=Pre1;
                    Pre1=Pre2;
                    Pre2+=Last;
                }
            }
        });


    }
}
