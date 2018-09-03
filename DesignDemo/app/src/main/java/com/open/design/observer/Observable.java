package com.open.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Observable<T> {
    List<Observer<T>> mObserver = new ArrayList<>();

    public void register(Observer<T> observer){
        if (observer==null){
            throw new NullPointerException("observer == null");
        }
        synchronized (this){
            if (!mObserver.contains(observer)){
                mObserver.add(observer);
            }
        }
    }

    public synchronized void unregiter(Observer<T> observer){
        mObserver.remove(observer);
    }

    public void notifyObservers(T data){
        for (Observer<T> observer:mObserver){
            observer.onUpdate(this,data);
        }
    }
}
