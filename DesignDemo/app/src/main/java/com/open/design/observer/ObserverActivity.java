package com.open.design.observer;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.open.design.R;
import com.open.design.ui.ActionBarActivity;
import com.open.design.ui.PrintActivity;
import com.open.design.ui.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/9/4.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class ObserverActivity extends ActionBarActivity {
    ListView listView;
    private List<WeatherObserver> observers = new ArrayList<>();
    WeatherObserver weatherObserver;
    Weather weather;
    int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        listView = findViewById(R.id.listview);
        weather = new Weather();
    }

    public void onClickAdd(View view){
        weatherObserver = new WeatherObserver(id);
        id++;
        weather.addObserver(weatherObserver);
        observers.add(weatherObserver);
        handler.sendEmptyMessage(0);
    }

    public void onClickChange(View view){
        weather.setDate("2018-09-04"+id);
        weather.setType(id);
        weather.setTypeName("type"+id);
        handler.sendEmptyMessage(0);
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            ObserverListAdapter myListAdapter = new ObserverListAdapter(ObserverActivity.this,
                    observers);
            listView.setAdapter(myListAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (id!=-1){
                        WeatherObserver observer = new WeatherObserver(1);
                        PrintActivity.startPrintActivity(ObserverActivity.this,"",observer.toString());
                    }
                }
            });
        };
    };

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.imgWeb:
                WebViewActivity.startWebViewActivity(this,"https://blog.csdn.net/u012124438/article/details/55294914/");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weather.deleteObserver(weatherObserver);
    }

    @Override
    public void onChanged(int themeType) {
        super.onChanged(themeType);
    }
}
