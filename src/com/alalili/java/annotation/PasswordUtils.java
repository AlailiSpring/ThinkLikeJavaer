package com.alalili.java.annotation;

import java.util.List;

/**
 * @Description: annotation used for recording how many times password has been used~
 * @Author: LiBaoDeng
 * @Date: 2021-01-30 23:49
 */
public class PasswordUtils {
    @UseCase(id = 47, descriprion = "password must contain at least one number")
    public boolean validationPassword(String password) {
        return (password.matches("\\w*\\d\\w"));
    }

    @UseCase(id = 48)
    public String ecryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id=49,descriprion = "New password can't equals previously used one")
    public boolean checkForNewPassword(List<String> prevPasswords,String password) {
        return !prevPasswords.contains(password);
    }
}
