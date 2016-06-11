package com.newer.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private TextView resultTextView;
    private TextView processTextView;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonDot;
    private Button buttonLeft;
    private Button buttonRight;

    private Button buttonResult;
    private Button buttonDelete;
    private Button buttonClear;

    private String process="";
    private String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        processTextView= (TextView) findViewById(R.id.textViewProcess);
        resultTextView= (TextView) findViewById(R.id.textViewResult);

        button0= (Button) findViewById(R.id.button0);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        button5= (Button) findViewById(R.id.button5);
        button6= (Button) findViewById(R.id.button6);
        button7= (Button) findViewById(R.id.button7);
        button8= (Button) findViewById(R.id.button8);
        button9= (Button) findViewById(R.id.button9);

        buttonDot= (Button) findViewById(R.id.buttonDot);
        buttonLeft= (Button) findViewById(R.id.buttonleft);
        buttonRight= (Button) findViewById(R.id.buttonright);

        buttonAdd= (Button) findViewById(R.id.buttonAdd);
        buttonSubtract= (Button) findViewById(R.id.buttonSubtract);
        buttonMultiply= (Button) findViewById(R.id.buttonMultiply);
        buttonDivide= (Button) findViewById(R.id.buttonDivide);

        buttonDelete= (Button) findViewById(R.id.buttonDelete);
        buttonClear= (Button) findViewById(R.id.buttonClear);
        buttonResult= (Button) findViewById(R.id.buttonResult);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        buttonDot.setOnClickListener(this);
        buttonLeft.setOnClickListener(this);
        buttonRight.setOnClickListener(this);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size=process.length();
                Log.d(TAG, "Delete" + process + "<<" + size + "<<" + process.substring(0, size - 1));
                if(process=="0"||size==1){
                    process="0";
                }else{
                    process=process.substring(0, size-1);
                }
                processTextView.setText(process);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process="0";
                processTextView.setText(process);
//                result="";
//                resultTextView.setText(result);
                process="";
                resultTextView.setText(process);
                process="0";
                Log.d(TAG, "Clear"+"<<"+result+"<<"+resultTextView.getText().toString());

            }
         });


        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(processTextView.getText().toString()=="0"){
                    result="0";
                }else{
                    result=new Calculator().result(process);
                    if(result.length()>9){
                        result=result.substring(0,10);
                    }
                }

                Log.d(TAG,result + "<<");

                if(result==""){
                    processTextView.setText(process);
                }else{
                    resultTextView.setText(process+"=");
                    processTextView.setText(result);
                }
                process="0";
            }
        });
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.button0:
              handleNumber(String.valueOf(0));
          break;
          case R.id.button1:
              handleNumber(String.valueOf(1));
              break;
          case R.id.button2:
              handleNumber(String.valueOf(2));
              break;
          case R.id.button3:
              handleNumber(String.valueOf(3));
              break;
          case R.id.button4:
              handleNumber(String.valueOf(4));
              break;
          case R.id.button5:
              handleNumber(String.valueOf(5));
              break;
          case R.id.button6:
              handleNumber(String.valueOf(6));
              break;
          case R.id.button7:
              handleNumber(String.valueOf(7));
              break;
          case R.id.button8:
              handleNumber(String.valueOf(8));
              break;
          case R.id.button9:
              handleNumber(String.valueOf(9));
              break;
          case R.id.buttonDot:
              handleNumber(".");
              break;
          case R.id.buttonleft:
              handleNumber("(");
              break;
          case R.id.buttonright:
              handleNumber(")");
              break;
          case R.id.buttonAdd:
              handleNumber("+");
              break;
          case R.id.buttonSubtract:
              handleNumber("-");
              break;
          case R.id.buttonMultiply:
              handleNumber("*");
              break;
          case R.id.buttonDivide:
              handleNumber("/");
              break;
      }
    }
    private void handleNumber(String num) {

        String [] op={"+","-","*","/"};
        for(int i=0;i<op.length;i++){
            if(op[i].equals(num)){
                process=result;
            }
        }

        if(process=="0"){
            process=num;
        }else{
            process=processTextView.getText().toString()+num;
        }
        processTextView.setText(process);

    }

}
