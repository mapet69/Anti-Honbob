package com.example.user.templates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    String n,b,c,d,y,wd,wb,wc; // 개인 정보 각각을 담을 변수를 설정해준다.
    TextView txt_main; // 화면에 출력할 textview 변수를 만들어준다.
    TextView txt_main2;
    TextView txt_main3;
    TextView txt_main4;
    TextView txt_main5;
    TextView txt_main6;
    TextView txt_main7;
    TextView txt_main8;

    TextView textViewname;
    TextView textViewDept;
    TextView textViewBoonban;
    TextView textViewClub;
    TextView textViewYear;
    TextView textViewDeptPri;
    TextView textViewBoonPri;
    TextView textViewClubPri;



    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


            // textview에서 받아온 내용을 미리 선언해둔 변수로 저장해온다.
        txt_main = (TextView)findViewById(R.id.textView);
        txt_main2 = (TextView)findViewById(R.id.textView2);
        txt_main3 = (TextView)findViewById(R.id.textView3);
        txt_main4 = (TextView)findViewById(R.id.textView4);
        txt_main5 = (TextView)findViewById(R.id.textView5);
        txt_main6 = (TextView)findViewById(R.id.textView6);
        txt_main7 = (TextView)findViewById(R.id.textView7);
        txt_main8 = (TextView)findViewById(R.id.textView8);
        textViewname= (TextView)findViewById(R.id.textViewName);
        textViewDept= (TextView)findViewById(R.id.textViewDept);
        textViewBoonban= (TextView)findViewById(R.id.textViewBoonban);
        textViewClub= (TextView)findViewById(R.id.textViewClub);
        textViewYear= (TextView)findViewById(R.id.textViewYear);
        textViewDeptPri= (TextView)findViewById(R.id.textViewDeptPri);
        textViewBoonPri= (TextView)findViewById(R.id.textViewBoonPri);
        textViewClubPri= (TextView)findViewById(R.id.textViewClubPri);
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
            textViewname.setText("Name");
            textViewDept.setText("Department");
            textViewBoonban.setText("Club");
            textViewYear.setText("Year");
            textViewDeptPri.setText("Priority of Department");
            textViewBoonPri.setText("Priority of Boonban");
            textViewClubPri.setText("Priority of Club");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

        // user data를 db에 push해주는 과정(db에 추가해주는 과정)
    private void writeNewUser(String Name, String Department, String Boon, String Club, String year, String tmpd, String tmpb, String tmpc) {
        ItemClass userdata = new ItemClass();
        userdata.setName(Name);
        userdata.setClub(Club);
        userdata.setBoonban(Boon);
        userdata.setDepartment(Department);
        userdata.setYear(year);
        userdata.setdw(tmpd);
        userdata.setbw(tmpb);
        userdata.setcw(tmpc);
        myRef.push().setValue(userdata);
    }

        // list에서 사람을 클릭했을 때 그 사람에 대한 정보를 확인할 수 있게 해주는 부분
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
        Intent intent02 = new Intent(this, Main4Activity.class);
        startActivity(intent02);
        this.finish();
    }
}
