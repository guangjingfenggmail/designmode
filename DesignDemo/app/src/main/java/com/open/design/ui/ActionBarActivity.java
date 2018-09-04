package com.open.design.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.open.design.R;
import com.open.design.observer.theme.AbstractThemeObserver;
import com.open.design.observer.theme.ThemeManager;
import com.open.design.utils.SharedPreferencesHelper;

import java.lang.ref.WeakReference;

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
public  class ActionBarActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityEventObserver mActivityEventObserver;
    ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomActionBar();
        mActivityEventObserver = new ActivityEventObserver(this);
        registerObserver(mActivityEventObserver);
    }


    private void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.action_bar, null);
        ImageView imgWeb = mActionBarView.findViewById(R.id.imgWeb);
        imgWeb.setOnClickListener(this);
        actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        onChanged(SharedPreferencesHelper.getInstance().getInt("themeType",0));
    }

    @Override
    public void onClick(View v) {

    }

    public void onChanged(int themeType){
        if (themeType==0){
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.theme_background));
        }else {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.theme_background1));
        }
    }


    public void registerObserver(AbstractThemeObserver observer){
        ThemeManager.getInstance().registerObserver(0,
                observer);
        ThemeManager.getInstance().registerObserver(1,
                observer);
    }

    public void unRegisterObserver(AbstractThemeObserver observer){
        ThemeManager.getInstance().removeObserver(0, observer);
        ThemeManager.getInstance().removeObserver(1, observer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterObserver(mActivityEventObserver);
    }

    private static class ActivityEventObserver extends AbstractThemeObserver{
        private final WeakReference<ActionBarActivity> mActivity;

        public ActivityEventObserver(ActionBarActivity activity){
            super();
            mActivity = new WeakReference<ActionBarActivity>(activity);
        }

        @Override
        public void onChanged(int themeType) {
            ActionBarActivity activity = mActivity.get();
            if (activity!=null  && !activity.isFinishing()){
                activity.onChanged(themeType);
            }
        }
    }
}
