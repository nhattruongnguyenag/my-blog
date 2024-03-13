package com.nhattruongnguyen.enums;

public enum PostAction {
    TRASH(0, "trash"),
    ACTIVE(1, "publish"),
    DRAFT(2, "draft"),
    ACHIEVE(3, "achieve"),
    DELETE(4, "delete"),
    RESTORE(5, "restore");

    private String name;
    private int value;

    PostAction(int value, String key) {
        this.value = value;
        this.name = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
