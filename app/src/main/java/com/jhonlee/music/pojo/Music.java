package com.jhonlee.music.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JhoneLee on 2017/3/13.
 */

public class Music implements Parcelable{

    /**
     * 歌曲id
     */
    private int id;
    /**
     * 歌手
     */
    private String singer;
    /**
     * 歌曲名
     */
    private String song;
    /**
     * 歌曲的地址
     */
    private String path;
    /**
     * 歌曲长度
     */
    private int duration;
    /**
     * 歌曲的大小
     */
    private long size;
    /*
     * 专辑名
     */
    private String album;
    /**
     * 专辑id
     */
    private int albumId;

    public Music(Parcel in) {
        id = in.readInt();
        singer = in.readString();
        song = in.readString();
        path = in.readString();
        duration = in.readInt();
        size = in.readLong();
        album = in.readString();
        albumId = in.readInt();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(singer);
        dest.writeString(song);
        dest.writeString(path);
        dest.writeInt(duration);
        dest.writeLong(size);
        dest.writeString(album);
        dest.writeInt(albumId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
