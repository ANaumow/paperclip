package com.exmple.testing.helpers;

import com.exmple.testing.model.AccountData;
import com.exmple.testing.ApplicationManager;
import org.openqa.selenium.By;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoginHelper extends HelperBase {

    private String loggedInEmail;

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void login(AccountData accountData) throws InterruptedException {
        if (isLoggedIn()) {
            if (isLoggedIn(accountData.getEmail())) {
                return;
            }
            logout();
        }

        manager.navigation().openSignInPage();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(accountData.getEmail());
        driver.findElement(By.name("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.cssSelector("input:nth-child(11)")).click();
        TimeUnit.SECONDS.sleep(1);
        loggedInEmail = accountData.getEmail();
        manager.navigation().openBlogPage();
    }

    public void logout() throws InterruptedException {
        manager.navigation().openProfilePage();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("form > input[value='logout']")).click();
        TimeUnit.SECONDS.sleep(1);
        loggedInEmail = null;
    }

    public void tryLogout() throws InterruptedException {
        if (isLoggedIn()) {
            logout();
        }
    }

    public boolean isLoggedIn() {
        return loggedInEmail != null;
    }

    public boolean isLoggedIn(String email) {
        return Objects.equals(email, loggedInEmail);
    }
}
