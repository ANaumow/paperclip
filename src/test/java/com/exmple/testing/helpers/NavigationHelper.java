package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    private final String baseUrl;

    public NavigationHelper(ApplicationManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void openSignInPage() {
        driver.get(baseUrl);
    }

    public void openBlogPage() {
        driver.findElement(By.linkText("My Blog")).click();
    }


}
