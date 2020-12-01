package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public boolean isOnPage(String path) {
        return driver.getCurrentUrl().equals(baseUrl + path);
    }

    public void openSignInPage() {
        driver.get(baseUrl + "/sign-in");
    }

    public void openProfilePage() {
        driver.get(baseUrl + "/profile");
    }

    public void openBlogPage() throws InterruptedException {
        openProfilePage();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.linkText("My Blog")).click();
        TimeUnit.SECONDS.sleep(3);
    }


}
