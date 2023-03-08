package com.example.myapplication;

import android.content.Intent;
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

public class minus extends AppCompatActivity {
    private TextView num;

    Button btn2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minus);
        num = (EditText)findViewById(R.id.number);
        num.setInputType( InputType.TYPE_CLASS_NUMBER);
        btn2 = (Button) findViewById(R.id.button);
    }
    public void minus(View view){
        String length = num.getText().toString();
        if (length.length() <= 0) {
            btn2.setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn2.setClickable(true);
                }
            }, 2000);
            Toast.makeText(this, "Введите хотябы одну цифру!", Toast.LENGTH_SHORT).show();// код отправки данных из форм на сервер
        }else{
            int res = Integer.parseInt(length);
            if(res> 5000){
                btn2.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn2.setClickable(true);
                    }
                }, 2000);
                Toast.makeText(this, "Вводите только цифры до 5000!", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    length = length + "\n";
                    FileOutputStream fileOutput = openFileOutput("minus.txt", MODE_APPEND);
                    fileOutput.write(length.getBytes());
                    fileOutput.close();
                    Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(minus.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}