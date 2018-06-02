package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    TextView t1;
    int n1 = 1, n2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        t1 = (TextView)findViewById(R.id.t1);
        b1.setText(String.valueOf(n1));
        b2.setText(String.valueOf(n2));
    }

    public void rc(View view) {
        t1.setText(t1.getText() + ", " + String.valueOf(n1 + n2));
        n2 = n1 + n2;
        b2.setText(String.valueOf(n2));
        b2.setEnabled(false);
        b1.setEnabled(true);
    }

    public void lc(View view) {
        t1.setText(t1.getText() + ", " + String.valueOf(n1 + n2));
        n1 = n1 + n2;
        b1.setText(String.valueOf(n1));
        b1.setEnabled(false);
        b2.setEnabled(true);
    }
}
