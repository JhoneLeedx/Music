package com.jhonlee.music.pojo;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class Song {

    /**
     * id : 28167620
     * name : 夜空中最亮的星
     * artists : [{"id":768306,"name":"网易云音乐","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}]
     * album : {"id":2732723,"name":"2013音乐人的年度歌曲推荐","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1388419200007,"size":32,"copyrightId":0,"status":0,"picId":5881287697065277}
     * duration : 284256
     * copyrightId : 0
     * status : 0
     * alias : ["郝云推荐"]
     * rtype : 0
     * ftype : 0
     * mvid : 0
     * fee : 0
     * rUrl : null
     */

    private int id;
    private String name;
    private Album album;
    private int duration;
    private int copyrightId;
    private int status;
    private int rtype;
    private int ftype;
    private int mvid;
    private int fee;
    private Object rUrl;
    private List<Artist> artists;
    private List<String> alias;

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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public int getMvid() {
        return mvid;
    }

    public void setMvid(int mvid) {
        this.mvid = mvid;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Object getRUrl() {
        return rUrl;
    }

    public void setRUrl(Object rUrl) {
        this.rUrl = rUrl;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }
}
