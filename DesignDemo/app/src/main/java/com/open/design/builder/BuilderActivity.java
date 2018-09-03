package com.open.design.builder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.open.design.R;
import com.open.design.builder.director.BuilderClient;
import com.open.design.builder.director.Director;
import com.open.design.builder.director.Traxex;
import com.open.design.builder.director.TraxexBuilder;
import com.open.design.ui.PrintActivity;
import com.open.design.ui.WebViewActivity;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/9/3.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class BuilderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_single, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.web_menu:
                WebViewActivity.startWebViewActivity(this,"https://blog.csdn.net/zhe_ge_sha_shou/article/details/53732158");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onClick1(View view){
        TraxexBuilder builder = new TraxexBuilder();
        Director director = new Director(builder);
        director.construct("Naga007", "Level_19");
        Traxex traxex = builder.build();

        BuilderClient client = new BuilderClient();
        toPrint(client.toString(), traxex.toString());
    }

    public void onClick2(View view){
        Person person = new Person.Builder()
                .age(30)
                .height(20)
                .name("person")
                .weight(30)
                .build();
        toPrint("",person.toString());
    }

    public void toPrint(String title,String content){
        PrintActivity.startPrintActivity(this,title,content);
    }
}
