package com.open.design.single;

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
public class Singleton4 {

    //将构造函数私有化
    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingleTonHoulder.singleTonInstance;
    }

    //静态内部类
    public static class SingleTonHoulder {
        private static final Singleton4 singleTonInstance = new Singleton4();
    }

    @Override
    public String toString() {
        return "第一次调用getInstance()方法的时候，虚拟机才会加载SingleTonHoulder静态内部类\n" +
                "\n" +
                "优点：线程安全，保证单例的唯一性，延迟了对象的实例化，是推荐的方式";
    }
}
