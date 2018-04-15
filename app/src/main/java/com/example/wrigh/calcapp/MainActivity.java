package com.example.wrigh.calcapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_plus=(Button)findViewById(R.id.plus);
        button_plus.setOnClickListener(this);
        Button button_minus=(Button)findViewById(R.id.minus);
        button_minus.setOnClickListener(this);
        Button button_multi=(Button)findViewById(R.id.multi);
        button_multi.setOnClickListener(this);
        Button button_division=(Button)findViewById(R.id.division);
        button_division.setOnClickListener(this);

        mEditText1=(EditText)findViewById(R.id.editText1);
        mEditText2=(EditText)findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        double val1=0;
        double val2=0;
        int symbol=0;

        switch (v.getId()){
            case R.id.plus:
                symbol=0;
                break;
            case R.id.minus:
                symbol=1;
                break;
            case R.id.multi:
                symbol=2;
                break;
            case R.id.division:
                symbol=3;
                break;
        }

        try{
            val1=Double.valueOf(mEditText1.getText().toString());
            val2=Double.valueOf(mEditText2.getText().toString());
        }
        catch (NumberFormatException e){
            val1=0.0;
            val2=0.0;
            symbol=4;
        }

        //ゼロ除算の回避
        if(val2 == 0.0&&symbol==3){
            symbol =4;
        }
        //ゼロで割れないようにする
        if(val1 == 0.0&&symbol==3){
            symbol =4;
        }

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("Value1",val1);
        intent.putExtra("Value2",val2);
        intent.putExtra("Symbol",symbol);
        startActivity(intent);

    }
}