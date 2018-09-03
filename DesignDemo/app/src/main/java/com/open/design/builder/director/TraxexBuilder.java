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
public class TraxexBuilder implements HeroBuilder {
    public String userName;
    public String level;
    private Traxex mTraxex;

    @Override
    public HeroBuilder userName(String name) {
        this.userName = name;
        return this;
    }

    @Override
    public HeroBuilder level(String level) {
        this.level = level;
        return this;
    }

    public Traxex build() {
        if (mTraxex == null) {
            mTraxex = new Traxex(this);
        }
        return mTraxex;
    }
}
