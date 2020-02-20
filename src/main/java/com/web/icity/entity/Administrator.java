package com.web.icity.entity;

public class Administrator {

    private int userID;

    private String account;

    private String password;

    private String name;

    public Administrator(String account, String password, String name){
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAccount() {
        return account.trim();
    }

    public void setAccount(String account) {
        this.account = account.trim();
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "admin:  " +
                "id:  " + userID +
                ",  account:  " + account +
                ",  password:  " + password +
                ",  real_name:  " + name;
    }
}
