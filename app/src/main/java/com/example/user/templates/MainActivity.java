package com.example.user.templates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



    // 첫 화면을 출력해주는 부분
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAct4(View view) { // 친구 찾기 화면으로 이동한다.
        Intent intent02 = new Intent(this, Main4Activity.class);
        startActivity(intent02);
    }

    public void toAct2(View view) { // 밥 먹을래! 화면으로 이동한다.
        Intent intent02 = new Intent(this, makeProfile.class);
        startActivity(intent02);
    }
    public void toAct3(View view) { // 회원 가입 화면으로 이동한다.
        Intent intent02 = new Intent(this, Main2Activity.class);
        startActivity(intent02);
    }
}
