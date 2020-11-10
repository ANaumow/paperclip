package com.exmple.testing;

import com.exmple.testing.helpers.CommentHelper;
import com.exmple.testing.helpers.LoginHelper;
import com.exmple.testing.helpers.NavigationHelper;
import com.exmple.testing.helpers.PostHelper;
import com.exmple.testing.helpers.WindowHelper;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    protected WebDriver driver;

    private final WindowHelper window;
    private final NavigationHelper navigation;
    private final LoginHelper login;
    private final CommentHelper comments;
    private final PostHelper posts;

    public ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "C:/Soft/chromedriver.exe");
        driver = new ChromeDriver();

        window = new WindowHelper(this);
        navigation = new NavigationHelper(this, "http://localhost:8080/sign-in");
        login = new LoginHelper(this);
        comments = new CommentHelper(this);
        posts = new PostHelper(this);
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Soft/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void stop() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WindowHelper window() {
        return window;
    }

    public NavigationHelper navigation() {
        return navigation;
    }

    public LoginHelper auth() {
        return login;
    }

    public CommentHelper comments() {
        return comments;
    }

    public PostHelper posts() {
        return posts;
    }
}
