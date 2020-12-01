package com.exmple.testing.tests;

import com.exmple.testing.model.AccountData;
import org.junit.Before;

public class AuthBase extends TestBase {

    @Before
    public void setUp() throws InterruptedException {
        String baseEmail = this.app.getSettings().getTestEmail();
        String basePassword = this.app.getSettings().getTestPassword();
        this.app.auth().login(new AccountData(baseEmail, basePassword));
    }

}
