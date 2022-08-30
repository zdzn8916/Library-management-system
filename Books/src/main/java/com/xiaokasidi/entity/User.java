package com.xiaokasidi.entity;

public class User {
    private Integer userId;
    private String userName;
    private String passWord;
    private String role;

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role=" + role +
                '}';
    }

    public User() {
    }

    public User(Integer userId, String userName, String passWord, String role) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
