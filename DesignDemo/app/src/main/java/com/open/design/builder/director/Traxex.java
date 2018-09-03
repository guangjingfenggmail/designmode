package com.open.design.builder.director;

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
public class Traxex implements Hero {
    private String userName; // 玩家id
    private String level; // 玩家等级


    public Traxex(TraxexBuilder builder) {
        this.userName = builder.userName;
        this.level = builder.level;
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public void setLevel(String level) {
        this.level = level;

    }

    @Override
    public String toString() {
        return "Traxex={" +
                "userName:" + userName +
                "level:" + level +
                "}";
    }
}
