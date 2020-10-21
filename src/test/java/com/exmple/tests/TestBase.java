package com.exmple.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Soft/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
//        driver.quit();
    }

    public void openSignInPage() {
        driver.get("http://localhost:8080/sign-in");
        driver.manage().window().setSize(new Dimension(1296, 696));
    }

    public void login(AccountData accountData) throws InterruptedException {
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(accountData.getEmail());
        driver.findElement(By.name("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.cssSelector("input:nth-child(11)")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void openBlogPage() {
        driver.findElement(By.linkText("My Blog")).click();
    }

    public void clickCreatePost() {
        driver.findElement(By.cssSelector(".text-break")).click();
    }

    public void createPost(PostData postData) throws InterruptedException {
        driver.findElement(By.cssSelector(".fa-eraser")).click();
        driver.findElement(By.cssSelector("pre:nth-child(3)")).click();
        driver.findElement(By.cssSelector("div:nth-child(1) > textarea")).sendKeys(postData.getText());
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("send-html")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void writeComment() throws InterruptedException {
        driver.findElement(By.cssSelector("#comment-icon-20 > .fas")).click();
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.id("textarea-20")).click();
        driver.findElement(By.id("textarea-20")).sendKeys("1111111");
        driver.findElement(By.cssSelector(".fa-paper-plane")).click();
    }

}
