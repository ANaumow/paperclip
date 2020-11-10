package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import org.openqa.selenium.Dimension;

public class WindowHelper extends HelperBase {

    public WindowHelper(ApplicationManager manager) {
        super(manager);
    }

    public void setDimension(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

}
