package com.jhonlee.music.pojo;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class Creator {

    /**
     * nickname : 网易云音乐
     * userId : 1
     * userType : 3
     * authStatus : 1
     */

    private String nickname;
    private int userId;
    private int userType;
    private int authStatus;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }
}
