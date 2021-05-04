package yieom.javastudy.contentprovidera;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHelper mDatabase;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        mDatabase = new DBHelper(getBaseContext());

        // 데이터 입력
        mDatabase.setDelete();
        List<ItemRow> mList = new ArrayList<>();
        mList.add(new ItemRow("식사","미역국",5000));
        mList.add(new ItemRow("간식","우유",4000));
        mList.add(new ItemRow("간식","바나나",3000));
        mList.add(new ItemRow("식사","오이",2000));
        mList.add(new ItemRow("식사","당근",1000));
        for(ItemRow item : mList) {
            mDatabase.setItem(item.contents, item.name, item.num);
        }

        Button bt_renew = (Button) findViewById(R.id.bt_renew);
        bt_renew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 데이터 불러오기
                loadData();
            }
        });

        Button module_btn = (Button) findViewById(R.id.module_btn);
        module_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("yieom.javastudy.technic","yieom.javastudy.contentproviderb.MainActivity");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadData() {
        StringBuilder sb = new StringBuilder();
        List<ItemRow> row = mDatabase.getItem();
        sb.append("Total count : "+row.size()+"\n\n");
        for(ItemRow item : row) {
            sb.append(item.contents+" , "+item.name+" , "+item.num+"\n");
        }
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setText(sb.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mDatabase != null)
            mDatabase.close();
    }
}