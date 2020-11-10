package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected WebDriver driver;
    protected ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.driver = manager.getDriver();
        this.manager = manager;
    }

}
