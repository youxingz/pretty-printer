package io.pretty.example;

import java.util.List;

public class User {
    private String username;
    private String avatar;
    private int age;
    private Float height;
    private String sign;

    private List<User> friends;

    public User(String username, String avatar, int age, Float height, String sign) {
        this.username = username;
        this.avatar = avatar;
        this.age = age;
        this.height = height;
        this.sign = sign;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
