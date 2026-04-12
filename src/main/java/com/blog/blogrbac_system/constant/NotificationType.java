package com.blog.blogrbac_system.constant;

public enum NotificationType {

    // USER
    USER_CREATED("Your account has been created successfully."),
    USER_UPDATED("Your account has been updated."),
    USER_DELETED("Your account has been deleted."),

    // ARTICLE
    ARTICLE_CREATED("Your article \"%s\" has been created successfully."),
    ARTICLE_UPDATED("Your article has been updated."),
    ARTICLE_DELETED("Your article has been deleted."),

    // CATEGORY
    CATEGORY_CREATED("A new category has been created."),
    CATEGORY_UPDATED("A category has been updated."),
    CATEGORY_DELETED("A category has been deleted.");

    private final String message;

    NotificationType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
