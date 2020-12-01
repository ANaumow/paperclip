package com.exmple.testing.model;

public class GroupData {

    private CommentData commentData;
    private PostData postData;

    public GroupData() {
    }

    public GroupData(CommentData commentData, PostData post) {
        this.commentData = commentData;
        this.postData = post;
    }

    public CommentData getCommentData() {
        return commentData;
    }

    public void setCommentData(CommentData commentData) {
        this.commentData = commentData;
    }

    public PostData getPostData() {
        return postData;
    }

    public void setPostData(PostData postData) {
        this.postData = postData;
    }
}
