package com.exmple.testing.helpers;

import com.exmple.testing.model.AccountData;
import com.exmple.testing.ApplicationManager;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData accountData) throws InterruptedException {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(accountData.getEmail());
        driver.findElement(By.name("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.cssSelector("input:nth-child(11)")).click();
        TimeUnit.SECONDS.sleep(1);
    }

}
