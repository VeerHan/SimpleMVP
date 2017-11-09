package com.example.leo.simplemvp;

import com.example.leo.simplemvp.base.BaseMvpView;

/**
 * @author lei.han
 * @time 2017/11/9 上午10:58
 */
public interface LoginView extends BaseMvpView {

    String getUsername();

    String getPassword();
}
