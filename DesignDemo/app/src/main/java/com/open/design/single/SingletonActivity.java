package com.open.design.single;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.open.design.R;
import com.open.design.ui.PrintActivity;

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
public class SingletonActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
    }


    public void onClick1(View view){
        toPrint("饿汉式 是最简单的实现方式，这种实现方式适合那些在初始化时就要用到单例的情况，这种方式简单粗暴，如果单例对象初始化非常快，而且占用内存非常小的时候这种方式是比较合适的，可以直接在应用启动时加载并初始化。 但是，如果单例初始化的操作耗时比较长而应用对于启动速度又有要求，或者单例的占用内存比较大，再或者单例只是在某个特定场景的情况下才会被使用，而一般情况下是不会使用时，使用饿汉式的单例模式就是不合适的，这时候就需要用到懒汉式的方式去按需延迟加载单例。"
                ,Singleton1.newInstance().toString());
    }

    public void onClick2(View view){
        toPrint("懒汉式与饿汉式的最大区别就是将单例的初始化操作，延迟到需要的时候才进行，这样做在某些场合中有很大用处。比如某个单例用的次数不是很多，但是这个单例提供的功能又非常复杂，而且加载和初始化要消耗大量的资源，这个时候使用懒汉式就是非常不错的选择。"
                ,Singleton2.newInstance().toString());
    }

    public void onClick3(View view){
        toPrint("可以看到上面在synchronized (Singleton.class)外又添加了一层if，这是为了在instance已经实例化后下次进入不必执行synchronized (Singleton.class)获取对象锁，从而提高性能。\n" +
                        "\n" +
                        "以上两种方式还是挺麻烦的，我们不禁要问，有没有更好的实现方式呢？答案是肯定的。 我们可以利用JVM的类加载机制去实现。在很多情况下JVM已经为我们提供了同步控制，比如：\n" +
                        "\n" +
                        "在static{}区块中初始化的数据\n" +
                        "\n" +
                        "访问final字段时\n" +
                        "\n" +
                        "等等\n" +
                        "\n" +
                        "因为在JVM进行类加载的时候他会保证数据是同步的，我们可以这样实现：\n" +
                        "\n" +
                        "采用内部类，在这个内部类里面去创建对象实例。这样的话，只要应用中不使用内部类 JVM 就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载和线程安全。"
                ,Singleton.getInstance().toString());
    }

    public void onClick4(View view){
        toPrint("",Singleton4.getInstance().toString());
    }

    public void onClick5(View view){
        toPrint("",Singleton4.getInstance().toString());
    }

    public void toPrint(String title,String content){
        PrintActivity.startPrintActivity(this,title,content);
    }
}
