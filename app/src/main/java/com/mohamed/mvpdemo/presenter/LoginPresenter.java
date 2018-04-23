package com.mohamed.mvpdemo.presenter;

import com.mohamed.mvpdemo.model.User;
import com.mohamed.mvpdemo.view.ILoginView;

/**
 * Created by mohamed on 23/04/18.
 */

public class LoginPresenter implements ILoginPresenter {
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        switch (user.isValidData()){
            case 0:
                iLoginView.onLoginError("You must enter email");
                break;
            case 1:
                iLoginView.onLoginError("You must enter valid email");
                break;
            case 2:
                iLoginView.onLoginError("Password must be greater than 6 character");
                break;
            case -1:
                iLoginView.onLoginSuccess("Login Successfully");
                break;
        }
    }
}
