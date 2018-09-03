package com.open.design.clone;

/**
 * ****************************************************************************************************************************************************************************
 * 原型模式
 * 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 * 1.实现Cloneable接口
 * 2.重写Object的clone方法
 * 3.实现clone方法中的拷贝逻辑
 *
 * Bundle类,Intent类,OkHttpClient
 * @author :guangjing.feng
 * @createTime: 2018/9/3.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Prototype implements Cloneable{
    private String type;
    private String typeName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public Object clone() {
        Prototype mPrototype = null;
        try {
            mPrototype = (Prototype) super.clone();
            mPrototype.type  = this.type;
            mPrototype.typeName = this.typeName;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return mPrototype;
    }

    @Override
    public String toString() {
        return "Prototype={" +
                "type:" +type+","+
                "typeName:"+typeName+
                "}";
    }
}
