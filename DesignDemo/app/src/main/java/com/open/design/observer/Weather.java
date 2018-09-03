package com.open.design.observer;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/8/31.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class Weather {
    private String description;


    public Weather(Builder builder){
        this.description = builder.description;
    }

    public static class Builder{
        private String description;

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Weather create(){
            return  new Weather(this);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "description:" + description+
                "}";
    }
}
