package com.aston.intensive;

public class User {

    @NotEmpty(message = "Username cannot be empty")   // можно установить свое сообщение
    private String name;

    @NotEmpty
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
