package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import com.exmple.testing.model.CommentData;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CommentHelper extends HelperBase {

    public CommentHelper(ApplicationManager manager) {
        super(manager);
    }

    public void clickWriteComment() throws InterruptedException {
        driver.findElement(By.cssSelector("#comment-icon-16 > .fas")).click();
        TimeUnit.SECONDS.sleep(3);
    }

    public void writeComment(CommentData commentData) throws InterruptedException {
        driver.findElement(By.id("textarea-16")).click();
        driver.findElement(By.id("textarea-16")).sendKeys(commentData.getText());
        driver.findElement(By.cssSelector(".fa-paper-plane")).click();
    }

}
