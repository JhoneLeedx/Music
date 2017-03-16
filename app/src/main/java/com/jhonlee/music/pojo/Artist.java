package com.jhonlee.music.pojo;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class Artist {


    /**
     * id : 9269
     * name : 容祖儿
     * picUrl : http://p4.music.126.net/VV4v0_aEuyjdnIuH6RP-6w==/5834008697196668.jpg
     * alias : ["Joey Yung"]
     * albumSize : 85
     * picId : 5834008697196668
     * img1v1Url : http://p3.music.126.net/RA9xjQ0ABACRcfKwutGDnA==/5946158883315120.jpg
     * img1v1 : 5946158883315120
     * mvSize : 354
     * followed : false
     * trans : null
     * transNames : ["魔力红"]
     * accountId : 19570392
     */

    private int id;
    private String name;
    private String picUrl;
    private int albumSize;
    private long picId;
    private String img1v1Url;
    private long img1v1;
    private int mvSize;
    private boolean followed;
    private String trans;
    private int accountId;
    private List<String> alias;
    private List<String> transNames;

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getAlbumSize() {
        return albumSize;
    }

    public void setAlbumSize(int albumSize) {
        this.albumSize = albumSize;
    }

    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }

    public String getImg1v1Url() {
        return img1v1Url;
    }

    public void setImg1v1Url(String img1v1Url) {
        this.img1v1Url = img1v1Url;
    }

    public long getImg1v1() {
        return img1v1;
    }

    public void setImg1v1(long img1v1) {
        this.img1v1 = img1v1;
    }

    public int getMvSize() {
        return mvSize;
    }

    public void setMvSize(int mvSize) {
        this.mvSize = mvSize;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public List<String> getTransNames() {
        return transNames;
    }

    public void setTransNames(List<String> transNames) {
        this.transNames = transNames;
    }
}
