package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import com.exmple.testing.model.PostData;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class PostHelper extends HelperBase {

    public PostHelper(ApplicationManager manager) {
        super(manager);
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

    public int getPostsCount() {
        return driver.findElements(By.className("custom-post-section")).size();
    }

    public int getUpperPostId() {
        String id = driver.findElement(By.className("markdown-body")).getAttribute("id").substring(16);
        return Integer.parseInt(id);
    }

}
