package com.example.myapplication;

import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class vieww extends AppCompatActivity {
    public TextView num1;
    public TextView  promresult;
    private EditText num;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vieww);
        num = findViewById(R.id.number);
        promresult = findViewById(R.id.textView2);
        num1 = findViewById(R.id.textView3);
        btn2 = findViewById(R.id.button);
    }
    public void plus(View view) {
        try{
            String date = num.getText().toString();
            if(date.length()!= 10){
                Toast.makeText(this, "Введите дату в формате xx.xx.xxxx", Toast.LENGTH_SHORT).show();
                btn2.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn2.setClickable(true);
                    }
                }, 2000);
            }else{
            FileInputStream fileinput1 = openFileInput("date.txt");
            InputStreamReader reader1 = new InputStreamReader(fileinput1);
            BufferedReader buffer1 = new BufferedReader(reader1);
            StringBuffer strBuffer1 = new StringBuffer();
            String lines1;
            while ((lines1 = buffer1.readLine()) != null) {
                if(lines1.contains(date)){
                    num1.setText("\n"+lines1+"\n");
                    return;
                }
            }
            num1.setText("Данных не обнаружено");}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}