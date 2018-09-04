package com.open.design.observer;

import java.util.Observable;

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
public class Weather extends Observable {
    private String date;
    private String typeName;
    private int type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        setChanged();
        notifyObservers();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
        setChanged();
        notifyObservers();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Weather={" +
                "date:" +date+","+
                "typeName:" +typeName+","+
                 "type:"+type+","+
                "}";
    }
}
