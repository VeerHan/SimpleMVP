package com.example.leo.simplemvp;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/**
 * @author lei.han
 * @time 2017/11/9 上午10:58
 */
public class LoginViewModel {

    private Handler handler = new Handler(Looper.getMainLooper());

    public void login(final String username, String password, final Callback callBack) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username)) {
                    callBack.onFailure();
                } else {
                    callBack.onSuccess();
                }
            }
        }, 1000);
    }
}
