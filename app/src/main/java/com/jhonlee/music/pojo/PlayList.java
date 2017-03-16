package com.jhonlee.music.pojo;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class PlayList {

    /**
     * id : 554473977
     * name : 2016年度最热新歌TOP100
     * coverImgUrl : http://p3.music.126.net/jIpqVAUvtZpTBUe8LDedlA==/18778559092465830.jpg
     * creator : {"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1}
     * subscribed : false
     * trackCount : 100
     * userId : 1
     * playCount : 13151834
     * bookCount : 214894
     * highQuality : false
     */

    private int id;
    private String name;
    private String coverImgUrl;
    private Creator creator;
    private boolean subscribed;
    private int trackCount;
    private int userId;
    private int playCount;
    private int bookCount;
    private boolean highQuality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }
}
