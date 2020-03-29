package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    private TextView ItemNum;
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        /**
         * 2020/3/28
         * 聊天界面跳转
         * 显示第几个Item
         */

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String str=bundle.getString("Item");
        ItemNum=findViewById(R.id.tv_content_info);

        ItemNum.setText(str);
        ItemNum.setTextColor(Color.WHITE);
    }

}
