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
public class Director {
    private HeroBuilder builder = null;

    public Director(HeroBuilder _builder) {
        builder = _builder;
    }

    public void construct(String _playerName, String _level) {
        builder
                .userName(_playerName)
                .level(_level);
    }

}
