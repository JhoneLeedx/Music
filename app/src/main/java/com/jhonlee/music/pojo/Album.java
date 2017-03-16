package com.jhonlee.music.pojo;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class Album {

    /**
     * id : 2732723
     * name : 2013音乐人的年度歌曲推荐
     * artist : {"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}
     * publishTime : 1388419200007
     * size : 32
     * copyrightId : 0
     * status : 0
     * picId : 5881287697065277
     */

    private int id;
    private String name;
    private Artist artist;
    private long publishTime;
    private int size;
    private int copyrightId;
    private int status;
    private long picId;

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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCopyrightId() {
        return copyrightId;
    }

    public void setCopyrightId(int copyrightId) {
        this.copyrightId = copyrightId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }
}
