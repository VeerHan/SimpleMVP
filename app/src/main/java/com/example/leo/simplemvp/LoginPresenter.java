package com.example.leo.simplemvp;

import com.example.leo.simplemvp.base.BaseMvpPresenter;

/**
 * @author lei.han
 * @time 2017/11/9 上午10:58
 */
public class LoginPresenter extends BaseMvpPresenter<LoginView> implements ILoginPresenter {

    private LoginViewModel viewModel;
    private LoginView loginView;

    public LoginPresenter(LoginViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void login() {
        checkViewAttach(); //检查是否绑定
        loginView = getMvpView();
        loginView.showLoading();
        viewModel.login(loginView.getUsername(), loginView.getPassword(), new Callback() {
            @Override
            public void onSuccess() {
                loginView.HideLoading();
                loginView.showSuccess();
            }

            @Override
            public void onFailure() {
                loginView.HideLoading();
                loginView.showError();
            }
        });
    }
}
