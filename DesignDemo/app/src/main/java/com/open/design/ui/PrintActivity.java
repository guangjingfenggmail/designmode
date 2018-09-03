package com.open.design.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.TextView;

import com.open.design.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
public class PrintActivity extends AppCompatActivity {
    TextView title;
    TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        title = findViewById(R.id.txtTitle);
        content = findViewById(R.id.txtContent);

        if (getIntent().getStringExtra("title")!=null){
            title.setText(getIntent().getStringExtra("title"));
        }

        if (getIntent().getStringExtra("content")!=null){
            content.setText(getIntent().getStringExtra("content"));
        }
    }

    public static void startPrintActivity(Context context,String title,String content){
        Intent intent = new Intent();
        intent.setClass(context,PrintActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        context.startActivity(intent);

    }


    public void onClickTitle(View view){
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        myClipboard.setText(title.getText().toString());
    }

    public void onClickContent(View view){
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        myClipboard.setText(content.getText().toString());
    }
}
