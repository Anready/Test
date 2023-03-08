package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finalday extends AppCompatActivity {
    private TextView num;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalday);
        num = (EditText)findViewById(R.id.editTextDate);
        btn2 = (Button) findViewById(R.id.button2);
    }
    public void onclic (View view){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int chekedButtonIndex = radioGroup.getCheckedRadioButtonId();
        int plus = 0;
        switch (chekedButtonIndex){
            case R.id.radioButton3:
                plus = 1;
                break;
            case R.id.radioButton4:
                plus = 2;
                break;
        }

        if(plus == 1){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            String date = formatter.format(calendar.getTime());
            int sum = 0;
            int sum1 = 0;
            try {
                int nums[] = new int [1000];
                int i = 0;
                FileInputStream fileinput = openFileInput("plus.txt");
                InputStreamReader reader = new InputStreamReader(fileinput);
                BufferedReader buffer = new BufferedReader(reader);
                StringBuffer strBuffer = new StringBuffer();
                String lines;
                while ((lines = buffer.readLine()) != null) {
                    nums[i] = Integer.parseInt(lines);
                    i++;
                }
                fileinput.close();
                for (int d = 0; d < nums.length; d++) {
                    sum = sum + nums[d];
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int res;
            try{
                int nums[] = new int [1000];
                int i = 0;
                FileInputStream fileinput1 = openFileInput("minus.txt");
                InputStreamReader reader1 = new InputStreamReader(fileinput1);
                BufferedReader buffer1 = new BufferedReader(reader1);
                StringBuffer strBuffer1 = new StringBuffer();
                String lines;
                while ((lines = buffer1.readLine()) != null) {
                    nums[i] = Integer.parseInt(lines);
                    i++;
                }
                fileinput1.close();
                for (int d = 0; d < nums.length; d++) {
                    sum1 = sum1 + nums[d];
                }

                res  = sum - sum1 - 900;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                String length = "";
                FileOutputStream fileOutput = openFileOutput("date.txt", MODE_APPEND);
                fileOutput.write(length.getBytes());
                fileOutput.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileInputStream fileinput1 = null;
                fileinput1 = openFileInput("date.txt");
                InputStreamReader reader1 = new InputStreamReader(fileinput1);
                BufferedReader buffer1 = new BufferedReader(reader1);
                StringBuffer strBuffer1 = new StringBuffer();
                String lines1;
                while ((lines1 = buffer1.readLine()) != null) {
                    if(lines1.contains(date)){
                        Toast.makeText(this, "Данные были введены ранее!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                fileinput1.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                date = date + " Калорий: "+ res +" В грамах "+res/9+"\n";
                FileOutputStream fileOutput = openFileOutput("date.txt", MODE_APPEND);
                fileOutput.write(date.getBytes());
                fileOutput.close();
                Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_SHORT).show();
                deleteFile("minus.txt");
                deleteFile("plus.txt");
                Intent intent = new Intent(Finalday.this, MainActivity.class);
                startActivity(intent);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        if(plus == 2){
            String length = num.getText().toString();
            if(length.length()!= 10){
                Toast.makeText(getApplicationContext(), "Введите дату в формате xx.xx.xxxx", Toast.LENGTH_SHORT).show();
                btn2.setClickable(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn2.setClickable(true);
                    }
                }, 2000);
            }else{
                int sum = 0;
                int sum1 = 0;
                try {
                    int nums[] = new int [1000];
                    int i = 0;
                    FileInputStream fileinput = openFileInput("plus.txt");
                    InputStreamReader reader = new InputStreamReader(fileinput);
                    BufferedReader buffer = new BufferedReader(reader);
                    StringBuffer strBuffer = new StringBuffer();
                    String lines;
                    while ((lines = buffer.readLine()) != null) {
                        nums[i] = Integer.parseInt(lines);
                        i++;
                    }
                    fileinput.close();
                    for (int d = 0; d < nums.length; d++) {
                        sum = sum + nums[d];
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int res;
                try{
                    int nums[] = new int [1000];
                    int i = 0;
                    FileInputStream fileinput1 = openFileInput("minus.txt");
                    InputStreamReader reader1 = new InputStreamReader(fileinput1);
                    BufferedReader buffer1 = new BufferedReader(reader1);
                    StringBuffer strBuffer1 = new StringBuffer();
                    String lines;
                    while ((lines = buffer1.readLine()) != null) {
                        nums[i] = Integer.parseInt(lines);
                        i++;
                    }
                    fileinput1.close();
                    for (int d = 0; d < nums.length; d++) {
                        sum1 = sum1 + nums[d];
                    }
                    res  = sum - sum1 - 900;
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    String length1 = "";
                    FileOutputStream fileOutput = openFileOutput("date.txt", MODE_APPEND);
                    fileOutput.write(length1.getBytes());
                    fileOutput.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileInputStream fileinput1 = null;
                    fileinput1 = openFileInput("date.txt");
                    InputStreamReader reader1 = new InputStreamReader(fileinput1);
                    BufferedReader buffer1 = new BufferedReader(reader1);
                    StringBuffer strBuffer1 = new StringBuffer();
                    String lines1;
                    while ((lines1 = buffer1.readLine()) != null) {
                        if(lines1.contains(length)){
                            Toast.makeText(this, "Данные были введены ранее!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    fileinput1.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    length = length + " Калорий: "+ res +" В грамах "+res/9+"\n";
                    FileOutputStream fileOutput = openFileOutput("date.txt", MODE_APPEND);
                    fileOutput.write(length.getBytes());
                    fileOutput.close();
                    Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_SHORT).show();
                    deleteFile("minus.txt");
                    deleteFile("plus.txt");
                    Intent intent = new Intent(Finalday.this, MainActivity.class);
                    startActivity(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }else{
            btn2.setClickable(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn2.setClickable(true);
                }
            }, 2000);
            Toast.makeText(this, "Выберите один из вариантов!", Toast.LENGTH_SHORT).show();
        }
    }
}