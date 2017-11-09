package com.example.leo.simplemvp.base;

/**
 * @author lei.han
 * @time 2017/11/9 上午11:19
 */
public interface Presenter<T extends BaseMvpView> {

    /**
     * presenter与对应的view绑定
     *
     * @param mvpView 目标view
     */
    void attachView(T mvpView);

    /**
     * presenter与对应的view解绑
     */
    void detachView();
}
