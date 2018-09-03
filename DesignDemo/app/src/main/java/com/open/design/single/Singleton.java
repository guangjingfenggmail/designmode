package com.open.design.single;

/**
 * ****************************************************************************************************************************************************************************
 *
 *必须防止外部可以调用构造函数进行实例化，因此构造函数必须私有化。
 必须定义一个静态函数获得该单例
 单例使用volatile修饰
 使用synchronized 进行同步处理，并且双重判断是否为null，我们看到synchronized (Singleton.class)里面又进行了是否为null的判断，这是因为一个线程进入了该代码，如果另一个线程在等待，这时候前一个线程创建了一个实例出来完毕后，另一个线程获得锁进入该同步代码，实例已经存在，没必要再次创建，因此这个判断是否是null还是必须的
 1.Android-Universal-Image-Loader中的单例
 2.EventBus中的单例
 3.InputMethodManager 中的单例
 4.AccessibilityManager 中的单例
 5.ActivityManager
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class) {
                if (instance==null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Double Check Lock(DCL模式）：双重检查锁定\n" +
                "\n" +
                "\n" +
                "public class SingleTon {\n" +
                "    //声明私有化\n" +
                "    private static SingleTon singleTonInstance;\n" +
                "    //将构造函数私有化\n" +
                "    private SingleTon() {\n" +
                "    }\n" +
                "    //Double Check Lock\n" +
                "    public static SingleTon getInstance(){\n" +
                "        if (singleTonInstance==null){\n" +
                "            synchronized (SingleTon.class){\n" +
                "                if (singleTonInstance==null){\n" +
                "                    singleTonInstance = new SingleTon();\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        return singleTonInstance;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "可以看到getInstance()方法对singleTonInstance进行两次判空，对懒汉式进行了优化，只有在第一次实例化的时候才会走第二个分支，才会同步，避免了每次都同步造成的不必要的资源消耗。\n" +
                "\n" +
                "优点：第一次执行getInstance方法时才会实例化，资源利用率高，效率高。\n" +
                "\n" +
                "缺点：偶尔失效（高并发条件下，由于JDK版本问题，在jdk1.5之前会失败）";
    }
}
