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
public class Singleton2 {

    private static Singleton2 instance = null;


    public Singleton2(){

    }

    public static Singleton2 newInstance(){
        if (instance==null){
            instance = new Singleton2();
        }
        return instance;
    }

    @Override
    public  String toString() {
        return "懒汉式\n" +
                "\n" +
                "\n" +
                "public class SingleTon {\n" +
                "    //声明私有化\n" +
                "    private static SingleTon singleTonInstance;\n" +
                "    //将构造函数私有化\n" +
                "    private SingleTon() {\n" +
                "    }\n" +
                "    //懒汉式\n" +
                "    private static synchronized SingleTon getInstance(){\n" +
                "        if (null==singleTonInstance){\n" +
                "            singleTonInstance = new SingleTon();\n" +
                "        }\n" +
                "        return singleTonInstance;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "优点：用到的时候才会去实例化，在一定程度上节约了资源。\n" +
                "\n" +
                "缺点：getInstance方法是用synchronized修饰的，该方法是同步的，为了保证线程安全，但是导致每次调用该方法的时候都会被同步，这样会消耗不必要的资源（不必要的同步开销）。所以这种模式一般不建议使用。";
    }

}
