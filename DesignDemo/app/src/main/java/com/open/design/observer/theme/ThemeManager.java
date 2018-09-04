package com.open.design.observer.theme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
public class ThemeManager implements ThemeWatcherInterface {
    private Map<String,ArrayList<AbstractThemeObserver>> mEventObservers = new HashMap<String,ArrayList<AbstractThemeObserver>>();
    private static volatile ThemeManager mThemeManager;

    public ThemeManager(){

    }


    public static ThemeManager getInstance(){
        if (mThemeManager==null){
            synchronized (ThemeManager.class) {
                if(mThemeManager==null) {
                    mThemeManager = new ThemeManager();
                }
            }
        }
        return mThemeManager;
    }

    @Override
    public void registerObserver(int themeType, AbstractThemeObserver observer) {
         synchronized (mEventObservers){
             ArrayList<AbstractThemeObserver> observers = mEventObservers.get(themeType+"");
             if (observers==null){
                 observers = new ArrayList<>();
                 mEventObservers.put(themeType+"",observers);
             }
             if (observers.contains(observer)){
                 return;
             }
             observers.add(observer);
         }

    }

    @Override
    public void removeObserver(int themeType, AbstractThemeObserver observer) {
        synchronized (mEventObservers){
            if (mEventObservers.containsKey(themeType+"")){
                ArrayList<AbstractThemeObserver> observers = mEventObservers.get(themeType+"");
                if (observers!=null && observers.size()>0){
                    observers.remove(observer);
                }
            }
        }
    }

    @Override
    public void notifyObserver(int themeType) {
        synchronized (mEventObservers) {
            if (mEventObservers.containsKey(themeType+"")) {
                ArrayList<AbstractThemeObserver> observers = mEventObservers.get(themeType+"");
                if (observers!=null && observers.size()>0){
                    for (AbstractThemeObserver o:observers){
                        o.onThemeChanged(themeType);
                    }
                }
            }
        }

    }
}
