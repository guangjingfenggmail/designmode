package com.open.design.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.open.design.R;
import com.open.design.observer.theme.ThemeManager;
import com.open.design.utils.SharedPreferencesHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    ClassListAdapter mClassListAdapter;
    List<ClassBean> list = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        try {
            // 这样就能获取ActivityInfo了，之后可以获得Activity的name
            ActivityInfo[] activities = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES).activities;
            list.clear();
            ClassBean allBean;
            for (ActivityInfo info : activities) {
                if (!MainActivity.class.getName().equals(info.name)
                        &&!PrintActivity.class.getName().equals(info.name)
                        &&!WebViewActivity.class.getName().equals(info.name)
                        && info.name.contains(getPackageName())) {
                    allBean = new ClassBean(info.name, getResources().getString(info.descriptionRes));
                    list.add(allBean);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        mClassListAdapter = new ClassListAdapter(this,list);
        listView.setAdapter(mClassListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id!=-1 && list!=null && list.size()>0){
                    Intent intent = new Intent();
                    intent.setClassName(getPackageName(), list.get((int)id).className);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.imgWeb:
                if (SharedPreferencesHelper.getInstance().getInt("themeType",0)==0){
                    SharedPreferencesHelper.getInstance().put("themeType",1);
                }else {
                    SharedPreferencesHelper.getInstance().put("themeType",0);
                }
                ThemeManager.getInstance().notifyObserver(SharedPreferencesHelper.getInstance().getInt("themeType",0));
                break;
        }
    }
}
