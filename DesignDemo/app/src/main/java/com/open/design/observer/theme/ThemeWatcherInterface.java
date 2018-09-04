package com.open.design.observer.theme;

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
public interface ThemeWatcherInterface {
    /**
     *
     * @param themeType
     * @param observer
     */
    public void registerObserver(int themeType,AbstractThemeObserver observer);

    /**
     *
     * @param themeType
     * @param observer
     */
    public void removeObserver(int themeType,AbstractThemeObserver observer);

    /**
     *
     * @param themeType
     */
    public void notifyObserver(int themeType);
}
