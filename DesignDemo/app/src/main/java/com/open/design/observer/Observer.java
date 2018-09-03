package com.open.design.observer;


/**
 * ****************************************************************************************************************************************************************************
 * 观察者模式
 * 定义对象间的一种一对多的依赖关系，当一个对象的状态发送改变时，所有依赖于它的对象都能得到通知并被自动更新
 * 观察者，我们称它为Observer，有时候我们也称它为订阅者，即Subscriber
 被观察者，我们称它为Observable，即可以被观察的东西，有时候还会称之为主题，即Subject
 至于观察者模式的具体实现，这里带带大家实现一下场景一，其实java中提供了Observable类和Observer接口供我们快速的实现该模式，但是为了加深印象，我们不使用这两个类。

 1.Android的广播机制，其本质也是观察者模式，这里为了简单方便，直接拿本地广播的代码说明，即LocalBroadcastManager。
 localBroadcastManager.registerReceiver(BroadcastReceiver receiver, IntentFilter filter);
 localBroadcastManager.unregisterReceiver(BroadcastReceiver receiver);
 2.EventBus也是基于观察者模式的。
 观察者模式的三个典型方法它都具有，即注册，取消注册，发送事件
 EventBus.getDefault().register(Object subscriber);
 EventBus.getDefault().unregister(Object subscriber);
 EventBus.getDefault().post(Object event);
 3.RxJava
 4.Button设置点击事件
 RecyclerView中的addOnScrollListener
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public interface Observer<T> {

    void onUpdate(Observable<T> observable,T data);
}
