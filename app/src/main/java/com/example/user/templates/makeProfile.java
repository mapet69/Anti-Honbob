package com.example.user.templates;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


    // profile을 만드는 code
public class makeProfile extends AppCompatActivity {


    String n,b,c,d,y,wd,wb,wc; // 우선 개인 정보를 담을 변수를 선언해준다.
    EditText txt_main;
    EditText txt_main2;
    EditText txt_main3;
    EditText txt_main4;
    EditText txt_main5;
    EditText txt_main6;
    EditText txt_main7;
    EditText txt_main8;
    // Write a message to the database



    public void onCreate(Bundle savedInstanceState) { // oncreate 이벤트가 실행되면 user data를 저장한다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_profile);
        txt_main = (EditText)findViewById(R.id.editText);
        txt_main2 = (EditText)findViewById(R.id.editText5);
        txt_main3 = (EditText)findViewById(R.id.editText6);
        txt_main4 = (EditText)findViewById(R.id.editText7);
        txt_main5 = (EditText)findViewById(R.id.editText8);
        txt_main6 = (EditText)findViewById(R.id.editText9);
        txt_main7 = (EditText)findViewById(R.id.editText10);
        txt_main8 = (EditText)findViewById(R.id.editText11);
        try {
            // 파일에서 읽은 데이터를 저장하기 위해서 만든 변수
            FileInputStream fis = openFileInput("myfile.txt");//파일명
            BufferedReader buffer = new BufferedReader
                    (new InputStreamReader(fis));
            String str = buffer.readLine(); // 파일에서 한줄을 읽어옴
            txt_main.setText(str);
            str = buffer.readLine();
            txt_main2.setText(str);
            str = buffer.readLine();
            txt_main3.setText(str);
            str = buffer.readLine();
            txt_main4.setText(str);
            str = buffer.readLine();
            txt_main5.setText(str);
            str = buffer.readLine();
            txt_main6.setText(str);
            str = buffer.readLine();
            txt_main7.setText(str);
            str = buffer.readLine();
            txt_main8.setText(str);
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    private void writeNewUser(String Name, String Department, String Boon, String Club, String year, String tmpd, String tmpb, String tmpc) {

        try {
            FileOutputStream fos = openFileOutput
                    ("myfile.txt", // 파일명 지정
                            Context.MODE_PRIVATE);// 저장모드
            PrintWriter out = new PrintWriter(fos);
            out.println(Name);
            out.println(Department);
            out.println(Boon);
            out.println(Club);
            out.println(year);
            out.println(tmpd);
            out.println(tmpb);
            out.println(tmpc);
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void finishAct(View view) {
        n = txt_main.getText().toString();
        d = txt_main2.getText().toString();
        b = txt_main3.getText().toString();
        c = txt_main4.getText().toString();
        y = txt_main5.getText().toString();
        wd = txt_main6.getText().toString();
        wb = txt_main7.getText().toString();
        wc = txt_main8.getText().toString();
        writeNewUser(n,d,b,c,y,wd,wb,wc);
        this.finish();
    }
}
