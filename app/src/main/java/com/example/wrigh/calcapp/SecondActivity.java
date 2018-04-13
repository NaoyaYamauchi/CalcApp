package com.example.wrigh.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("Value1",0);
        double value2 = intent.getDoubleExtra("Value2",0);
        int symbol = intent.getIntExtra("Symbol",0);

        TextView textView =(TextView)findViewById(R.id.textView);

        switch (symbol){
            case 0:
                textView.setText(String.valueOf(value1+value2));
                break;
            case 1:
                textView.setText(String.valueOf(value1-value2));
                break;
            case 2:
                textView.setText(String.valueOf(value1*value2));
                break;
            case 3:
                textView.setText(String.valueOf(value1/value2));
                break;
            case 4:
                textView.setText("ERROR!!");
                break;
        }

    }
}