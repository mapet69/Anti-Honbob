package com.example.user.templates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;



    // listview를 담당하는 부분

public class Main4Activity extends AppCompatActivity {
    ItemClass me = new ItemClass(); // db로부터 받아온 item을 받아올 새로운 객체를 생성해준다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        try {
            // 파일에서 읽은 데이터를 핸드폰 단말기에 저장하기 위해서 만든 변수
            StringBuffer data = new StringBuffer();
            FileInputStream fis = openFileInput("myfile.txt");//파일명
            BufferedReader buffer = new BufferedReader
                    (new InputStreamReader(fis));
            String str = buffer.readLine(); // 파일에서 한줄을 읽어옴
            me.setName(str);
            str = buffer.readLine();
            me.setDepartment(str);
            str = buffer.readLine();
            me.setBoonban(str);
            str = buffer.readLine();
            me.setClub(str);
            str = buffer.readLine();
            me.setYear(str);
            str = buffer.readLine();
            me.setdw(str);
            str = buffer.readLine();
            me.setcw(str);
            str = buffer.readLine();
            me.setbw(str);
            me.setScore(0);
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        final ListView listview ;
        listview = (ListView) findViewById(R.id.listview1);
            // 이 어플리케이션이 db를 받아오는 부분. 아래의 http~ 부분에 db가 저장되어있고 이 db를 받아와서 사용한다.
        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://teamproject-e2836.firebaseio.com/");
            // 받아온 db에서 정보를 읽어오는 code
        final FirebaseListAdapter<ItemClass> listViewItemList = new FirebaseListAdapter<ItemClass>(this,ItemClass.class,R.layout.listview_item,ref)
        {
            @Override
            protected void populateView(View v, ItemClass model, int position)
            {
                TextView titleTextView = (TextView) v.findViewById(R.id.textView1) ;
                TextView descTextView = (TextView) v.findViewById(R.id.textView2) ;

                model.calScore(me);
                // 아이템 내 각 위젯에 데이터 반영
                titleTextView.setText(model.getName());
                descTextView.setText(Double.toString(model.getScore()));
            }
        };
        listview.setAdapter(listViewItemList); // itemlist를 adapt하여 view로 올리는 과정
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ItemClass item = (ItemClass) parent.getItemAtPosition(position) ;

                String seletectedName = item.getName() ;
                String seletectedDepartment = item.getDepartment() ;
                String seletectedBoonban = item.getBoonban() ;
                String seletectedClub = item.getClub() ;


                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                intent.putExtra("name",item.getName());
                intent.putExtra("department",item.getDepartment());
                intent.putExtra("boonban",item.getBoonban());
                intent.putExtra("club",item.getClub());

                startActivity(intent);

                // TODO : use item data.
            }
        }) ;

       

    }


}

