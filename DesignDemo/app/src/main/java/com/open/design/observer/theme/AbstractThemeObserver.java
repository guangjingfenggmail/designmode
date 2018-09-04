package com.open.design.observer.theme;

import android.os.Handler;
import android.os.Looper;


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
public abstract class AbstractThemeObserver implements ThemeChangeListener{
    private Handler mHandler;

    public AbstractThemeObserver(){
        mHandler = new Handler(Looper.getMainLooper());
    }

    public abstract void onChanged(int themeType);

    @Override
    public void onThemeChanged(int themeType) {
        mHandler.post(new ThemeRunnable(themeType));
    }

    private final class ThemeRunnable implements Runnable{
        private int themeType;
        public ThemeRunnable(int themeType){
            this.themeType = themeType;
        }
        @Override
        public void run() {
            AbstractThemeObserver.this.onChanged(themeType);
        }
    }
}
