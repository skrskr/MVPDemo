package com.mohamed.mvpdemo.model;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by mohamed on 23/04/18.
 */

public class User implements IUser {

    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if(getPassword().length() < 6)
            return 2;
        else
            return -1;
    }
}
