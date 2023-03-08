package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class MainActivity extends AppCompatActivity {
    public TextView promresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        promresult = findViewById(R.id.promresult);
        f();
        prom();

    }
    public void f(){
        String length =  "";
        try {
            FileOutputStream fileOutput = openFileOutput("minus.txt", MODE_APPEND);
            fileOutput.write(length.getBytes());
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutput = openFileOutput("plus.txt", MODE_APPEND);
            fileOutput.write(length.getBytes());
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileOutput = openFileOutput("date.txt", MODE_APPEND);
            fileOutput.write(length.getBytes());
            fileOutput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void plus(View view){
        Intent intent = new Intent(MainActivity.this, plus.class);
        startActivity(intent);
    }
    public void minus(View view){
        Intent intent = new Intent(MainActivity.this, minus.class);
        startActivity(intent);
    }
    public void finalday(View view){
        Intent intent = new Intent(MainActivity.this, Finalday.class);
        startActivity(intent);
    }
    public void view(View view){
        Intent intent = new Intent(MainActivity.this, vieww.class);
        startActivity(intent);
    }
    public void prom(){
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
            int res  = sum - sum1 - 900;
            String res1 = String.valueOf(res);
            promresult.setText(res1.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}