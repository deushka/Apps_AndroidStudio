package com.example.asus.calculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,comma,eq,CE,div,minus,multi,plus;
    char operation, curOperation;
    int times;
    double curAns, last;
    int here;


    TextView text;
    protected void display(String press){
        if (text.getText().toString().equals("0")||curOperation!='N'){
            text.setText(press);
            curOperation = 'N';
            times++;
        }else{
            text.setText(text.getText().toString()+press);
        }
    }
    protected double Operate(double curAns, double cur){
        switch (operation){
            case '+':return curAns+cur;
            case '-':return curAns-cur;
            case '*':return curAns*cur;
            case '/':return curAns/cur;
        }
        return curAns;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        curAns=0;
        last=0;
        operation = 'N';
        curOperation = 'N';
        text = (TextView) findViewById(R.id.textView);
        bt1 = (Button)findViewById(R.id.button4);
        bt2 = (Button)findViewById(R.id.button5);
        bt3 = (Button)findViewById(R.id.button6);
        bt4 = (Button)findViewById(R.id.button7);
        bt5 = (Button)findViewById(R.id.button8);
        bt6 = (Button)findViewById(R.id.button9);
        bt7 = (Button)findViewById(R.id.button10);
        bt8 = (Button)findViewById(R.id.button11);
        bt9 = (Button)findViewById(R.id.button12);
        bt0 = (Button)findViewById(R.id.button2);
        comma = (Button)findViewById(R.id.button);
        eq = (Button)findViewById(R.id.button3);
        CE = (Button)findViewById(R.id.button13);
        div = (Button)findViewById(R.id.button16);
        minus = (Button)findViewById(R.id.button17);
        multi = (Button)findViewById(R.id.button15);
        plus = (Button)findViewById(R.id.button14);
        times=0;

        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("0");
                operation = 'N';
                times=0;
                curOperation = 'N';
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (here == 1){
                    here=0;
                    curAns=Double.parseDouble(text.getText().toString());
                    times=1;
                }else {

                    if (times > 1) {
                        last = Double.parseDouble(text.getText().toString());
                        curAns = Operate(curAns, last);
                        text.setText((curAns - (int) curAns == 0.0 ? (int) curAns : curAns) + "");
                        times = 1;
                    } else {
                        if (times == 1) {
                            curAns = Double.parseDouble(text.getText().toString());
                        }
                    }
                }
                curOperation = '/';
                operation ='/';
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (here == 1){
                    here=0;
                    curAns= Double.parseDouble(text.getText().toString());
                    times=1;
                }else {

                    if (times > 1) {
                        last = Double.parseDouble(text.getText().toString());
                        curAns = Operate(curAns, last);
                        text.setText((curAns - (int) curAns == 0.0 ? (int) curAns : curAns) + "");
                        times = 1;
                    } else {
                        if (times == 1) {
                            curAns = Double.parseDouble(text.getText().toString());
                        }
                    }
                }
                curOperation = '*';
                operation ='*';
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curOperation = '-';
                if (here == 1){
                    here=0;
                    curAns=Double.parseDouble(text.getText().toString());
                    times=1;
                }else {
                    if (times > 1) {
                        last = Double.parseDouble(text.getText().toString());
                        curAns = Operate(curAns, last);
                        text.setText((curAns - (int) curAns == 0.0 ? (int) curAns : curAns) + "");
                        times = 1;
                    } else {
                        if (times == 1) {
                            curAns = Double.parseDouble(text.getText().toString());
                        }
                    }
                }
                operation ='-';
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curOperation = '+';
                if (here == 1){
                    here=0;
                    curAns=Double.parseDouble(text.getText().toString());
                    times=1;
                }else {
                    if (times > 1) {
                        last = Double.parseDouble(text.getText().toString());
                        curAns = Operate(curAns, last);
                        text.setText((curAns - (int) curAns == 0.0 ? (int) curAns : curAns) + "");
                        times = 1;
                    } else {
                        if (times == 1) {
                            curAns = Double.parseDouble(text.getText().toString());
                        }
                    }
                }
                operation ='+';
            }
        });
        here=0;
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curOperation=='N' && operation!='N'){
                    if (here != 1){
                        last=Double.parseDouble(text.getText().toString());
                        here=1;
                    }
                    curAns = Operate(curAns, last);

                    text.setText((curAns-(int)curAns==0?(int)curAns:curAns)+"");
                    times=1;
                }
            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("9");
            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display("0");
            }
        });
        comma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!text.getText().toString().contains(".")){
                    display(".");
                }
            }
        });

    }
}
