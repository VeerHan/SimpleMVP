package com.example.leo.simplemvp;

/**
 * @author lei.han
 * @time 2017/11/9 上午10:58
 */
public interface LoginView {

    void showSuccess();

    void showError();

    void showLoading();

    void HideLoading();

    String getUsername();

    String getPassword();
}
