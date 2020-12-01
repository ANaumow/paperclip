package com.exmple.testing.tests;

import com.exmple.testing.model.AccountData;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginWithValidData() throws InterruptedException {
        this.app.auth().login(new AccountData("test@mail.ru", "123"));
        Assert.assertTrue(this.app.navigation().isOnPage("/profile"));
    }

    @Test
    public void loginWithInvalidData() throws InterruptedException {
        this.app.auth().login(new AccountData("test@mail.ru", "1234"));
        Assert.assertTrue(this.app.navigation().isOnPage("/sign-in?error"));

    }

}
