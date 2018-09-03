package com.open.design.single;

/**
 * ****************************************************************************************************************************************************************************
 * @author :guangjing.feng
 * @createTime: 2018/9/3.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Singleton1 {

    private static final Singleton1 instance = new Singleton1();

    public Singleton1(){

    }

    public static Singleton1 newInstance() {
        return instance;
    }


    @Override
    public  String toString() {
        return "饿汉式\n" +
                "\n" +
                "\n" +
                "public class SingleTon {\n" +
                "    //将构造函数私有化\n" +
                "    private SingleTon() {\n" +
                "    }\n" +
                " \n" +
                "    //创建私有实例对象\n" +
                "    private static final SingleTon singleTonInstance = new SingleTon();\n" +
                " \n" +
                "    //对外提供方法，返回实例对象\n" +
                "    public static SingleTon getInstance() {\n" +
                "        return singleTonInstance;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "优点：简单，线程安全。\n" +
                "\n" +
                "缺点：实例对象是static的，在声明的时候就实例化了，浪费资源。";
    }
}
