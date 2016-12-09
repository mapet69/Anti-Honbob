package com.example.user.templates;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

// 특정 한 사람의 개인 정보/프로필을 확인할 수 있는 부분

public class Main3Activity extends AppCompatActivity {

    TextView txt_next;
    TextView txt_next2;
    TextView txt_next3;
    TextView txt_next4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


            // 이름, 과, 분반, 동아리를 출력해준다.
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String depa = intent.getStringExtra("department");
        String boon = intent.getStringExtra("boonban");
        String club = intent.getStringExtra("club");

        txt_next = (TextView) findViewById(R.id.txt_next);
        txt_next.setText(name);
        txt_next2 = (TextView) findViewById(R.id.txt_next2);
        txt_next2.setText(depa);
        txt_next3 = (TextView) findViewById(R.id.txt_next3);
        txt_next3.setText(boon);
        txt_next4 = (TextView) findViewById(R.id.txt_next4);
        txt_next4.setText(club);
    }
        // 이 사람과 밥을 먹기 위해 연락을 하려 할 때 전화를 걸어주는 intent 실행
    public void onClick01(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-6455-4787"));
        startActivity(intent);
    }
}

