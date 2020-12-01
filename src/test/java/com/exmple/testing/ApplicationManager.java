package com.exmple.testing;

import com.exmple.testing.helpers.CommentHelper;
import com.exmple.testing.helpers.LoginHelper;
import com.exmple.testing.helpers.NavigationHelper;
import com.exmple.testing.helpers.PostHelper;
import com.exmple.testing.helpers.WindowHelper;
import com.exmple.testing.model.AccountData;
import com.exmple.testing.model.Settings;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ApplicationManager {

    protected Settings settings;
    protected WebDriver driver;

    private final WindowHelper window;
    private final NavigationHelper navigation;
    private final LoginHelper login;
    private final CommentHelper comments;
    private final PostHelper posts;

    private static final ThreadLocal<ApplicationManager> app = new ThreadLocal<>();

    private ApplicationManager() throws IOException {
        settings = new ObjectMapper().readValue(new File("Settings.json"), Settings.class);
        System.setProperty(settings.getDriverPropertyName(), settings.getDriverPath());
        driver = new ChromeDriver();
        window = new WindowHelper(this);
        navigation = new NavigationHelper(this, settings.getBaseUrl());
        login = new LoginHelper(this);
        comments = new CommentHelper(this);
        posts = new PostHelper(this);
    }

    public static ApplicationManager getInstance() throws IOException {
        ApplicationManager manager = app.get();
        if (manager == null) {
            manager = new ApplicationManager();
            manager.window().setDimension(1296, 696);
            app.set(manager);
        }
        return manager;
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

    public Settings getSettings() {
        return settings;
    }
}
