package com.example.leo.simplemvp;

/**
 * @author lei.han
 * @time 2017/11/9 上午10:58
 */
public class LoginPresenter {

    private LoginViewModel viewModel;
    private LoginView loginView;

    public LoginPresenter(LoginViewModel viewModel, LoginView loginView) {
        this.viewModel = viewModel;
        this.loginView = loginView;
    }

    public void login(String username, String password) {
        loginView.showLoading();
        viewModel.login(username, password, new Callback() {
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
