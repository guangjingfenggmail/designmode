package com.open.design.strategy;

import android.util.Log;

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
public class TravelStrategy {
    public enum Strategy{
        WALK,
        PLANE,
        SUBWAY
    }

    protected Strategy mStrategy;
    public TravelStrategy(Strategy strategy){
        this.mStrategy = strategy;
    }

    public void travel(){
        if (mStrategy == Strategy.WALK){
            Log.d("TravelStrategy","walk");
        }else  if (mStrategy == Strategy.PLANE){
            Log.d("TravelStrategy","plane");
        }else  if (mStrategy == Strategy.SUBWAY){
            Log.d("TravelStrategy","subway");
        }
    }

    public void print(String str){
        System.out.println("出行旅游的方式为："+str);
    }

//    public static void main(String[] args) {
//        TravelStrategy walk=new TravelStrategy(Strategy.WALK);
//        walk.travel();
//
//        TravelStrategy plane=new TravelStrategy(Strategy.PLANE);
//        plane.travel();
//
//        TravelStrategy subway=new TravelStrategy(Strategy.SUBWAY);
//        subway.travel();
//    }
}
