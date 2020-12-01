package com.exmple.testing.helpers;

import com.exmple.testing.ApplicationManager;
import com.exmple.testing.model.CommentData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CommentHelper extends HelperBase {

    public CommentHelper(ApplicationManager manager) {
        super(manager);
    }

    public void clickWriteCommentOnUpperPost() throws InterruptedException {
        int id = manager.posts().getUpperPostId();
        driver.findElement(By.cssSelector("#comment-icon-" + id + " > .fas")).click();
        TimeUnit.SECONDS.sleep(3);
    }

    public void writeCommentOnUpperPost(CommentData commentData) throws InterruptedException {
        int id = manager.posts().getUpperPostId();
        driver.findElement(By.id("textarea-" + id)).click();
        driver.findElement(By.id("textarea-" + id)).sendKeys(commentData.getText());
        driver.findElement(By.cssSelector(".fa-paper-plane")).click();
        TimeUnit.SECONDS.sleep(3);
    }

    public int getUpperPostCommentsCount() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        int id = manager.posts().getUpperPostId();

        return driver.findElements(By.cssSelector("#comments-section-" + id + " div[id^=\"post-comment-\"]")).size();
    }

}
