package com.example.leo.simplemvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 *
 * @author lei.han
 * @time 2017/11/9 上午10:58
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    private AutoCompleteTextView mEtEmail;
    private EditText mEtPassword;
    private View mProgressView;

    private LoginPresenter mPresenter;
    private Button mBtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initPresenter();
    }

    private void initView() {
        mEtEmail = (AutoCompleteTextView) findViewById(R.id.email);
        mEtPassword = (EditText) findViewById(R.id.password);
        mProgressView = findViewById(R.id.login_progress);
        mBtnSignIn = (Button) findViewById(R.id.email_sign_in_button);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
    }

    private void initPresenter() {
        mPresenter = new LoginPresenter(new LoginViewModel());
        mPresenter.attachView(this);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "login fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideLoading() {
        mProgressView.setVisibility(View.GONE);
    }

    @Override
    public String getUsername() {
        return mEtEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }
}

