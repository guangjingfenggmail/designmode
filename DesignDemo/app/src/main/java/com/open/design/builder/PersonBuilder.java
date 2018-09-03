package com.open.design.builder;

import android.net.Uri;

/**
 * ****************************************************************************************************************************************************************************
 *定义一个静态内部类Builder，内部的成员变量和外部类一样
 Builder类通过一系列的方法用于成员变量的赋值，并返回当前对象本身（this）
 Builder类提供一个build方法或者create方法用于创建对应的外部类，该方法内部调用了外部类的一个私有构造函数，该构造函数的参数就是内部类Builder
 外部类提供一个私有构造函数供内部类调用，在该构造函数中完成成员变量的赋值，取值为Builder对象中对应的值
 1.AlertDialog.Builder builder=new AlertDialog.Builder(this);
 2.GsonBuilder builder=new GsonBuilder();
 3.EventBus中也有一个Builder，只不过这个Builder外部访问不到而已，因为它的构造函数不是public的
 4.Request.Builder builder=new Request.Builder();
     Request request=builder.addHeader("","")
     .url("")
     .post(body)
     .build();
 5.Request外，Response也是通过Builder模式创建的。贴一下Response的构造函数
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class PersonBuilder {
    private String name;
    private int age;
    private double height;
    private double weight;

    private PersonBuilder(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }


    public static  class  Builder{
        private String name;
        private int age;
        private double height;
        private double weight;


        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder height(double height){
            this.height = height;
            return this;
        }

        public Builder weight(double weight){
            this.weight = weight;
            return this;
        }
    }

}
