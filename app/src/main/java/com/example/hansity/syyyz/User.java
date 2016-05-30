package com.example.hansity.syyyz;

/**
 * Created by samsung- on 2016/5/30.
 */
public class User {
    private long id;
    private String UserName;
    private String PassWord;

    public User(int id, String userName, String passWord) {
        this.id = id;
        UserName = userName;
        PassWord = passWord;
    }
    public User() {
        this.id = 1;
        UserName = null;
        PassWord = null;
    }
    public long getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
