package com.example.leo.simplemvp;

/**
 * @author lei.han
 * @time 2017/11/9 上午11:13
 */
public interface IUserModel {

    /**
     * 登录逻辑处理
     *
     * @param username
     * @param password
     * @param callback
     */
    void login(String username, String password, Callback callback);
}
