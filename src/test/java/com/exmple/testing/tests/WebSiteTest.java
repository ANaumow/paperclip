package com.exmple.testing.tests;

import org.junit.Assert;
import org.junit.Test;

public class WebSiteTest extends AuthBase {

    @Test
    public void writeComment() throws InterruptedException {
        app.comments().clickWriteCommentOnUpperPost();
        int beginCount = app.comments().getUpperPostCommentsCount();
        app.comments().writeCommentOnUpperPost(groupData.getCommentData());
        int endCount = app.comments().getUpperPostCommentsCount();
        System.out.println(beginCount);
        System.out.println(endCount);
        Assert.assertEquals(endCount, beginCount + 1);
    }
    
    @Test
    public void createPost() throws InterruptedException {
        int beginCount = app.posts().getPostsCount();
        app.posts().clickCreatePost();
        app.posts().createPost(groupData.getPostData());
        int endCount = app.posts().getPostsCount();
        System.out.println(beginCount);
        System.out.println(endCount);
        Assert.assertEquals(endCount, beginCount + 1);
    }

}
