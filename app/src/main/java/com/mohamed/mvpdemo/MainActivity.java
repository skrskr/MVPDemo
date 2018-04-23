package com.mohamed.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mohamed.mvpdemo.presenter.LoginPresenter;
import com.mohamed.mvpdemo.view.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView{

    private LoginPresenter loginPresenter;
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.editText_user_email);
        passwordEditText = findViewById(R.id.editText_user_password);

        loginPresenter = new LoginPresenter(this);



    }

    public void loginClick(View view) {
        loginPresenter.onLogin(emailEditText.getText().toString(),passwordEditText.getText().toString());
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message,Toast.LENGTH_SHORT,true).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toast.LENGTH_SHORT,true).show();
    }
}
