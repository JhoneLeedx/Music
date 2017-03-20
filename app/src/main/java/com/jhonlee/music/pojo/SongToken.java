package com.jhonlee.music.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/17.
 */

public class SongToken {


    /**
     * songs : [{"name":"我们万岁","id":456175812,"position":1,"alias":[],"status":0,"fee":8,"copyrightId":15001,"disc":"","no":1,"artists":[{"name":"BBF","id":12139308,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"album":{"name":"我们万岁 (庆功版)","id":35158222,"type":"专辑","size":12,"picId":18502581673986781,"blurPicUrl":"http://p3.music.126.net/fUqUwYisQBKMV3Qx1yEatQ==/18502581673986781.jpg","companyId":0,"pic":18502581673986781,"picUrl":"http://p4.music.126.net/fUqUwYisQBKMV3Qx1yEatQ==/18502581673986781.jpg","publishTime":1486310400007,"description":"","tags":"","company":"简单快乐","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":3,"copyrightId":15001,"commentThreadId":"R_AL_3_35158222","artists":[{"name":"BBF","id":12139308,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":"录音室版","picId_str":"18502581673986781"},"starred":false,"popularity":95,"score":95,"starredNum":0,"duration":198315,"playedNum":0,"dayPlays":0,"hearTime":0,"ringtone":null,"crbt":null,"audition":null,"copyFrom":"","commentThreadId":"R_SO_4_456175812","rtUrl":null,"ftype":0,"rtUrls":[],"copyright":2,"hMusic":{"name":null,"id":1278156576,"size":7934999,"extension":"mp3","sr":44100,"dfsId":18644418673971033,"bitrate":320000,"playTime":198315,"volumeDelta":-3.82,"dfsId_str":"18644418673971033"},"mMusic":{"name":null,"id":1278156577,"size":3967522,"extension":"mp3","sr":44100,"dfsId":18733479115821694,"bitrate":160000,"playTime":198315,"volumeDelta":-3.44,"dfsId_str":"18733479115821694"},"lMusic":{"name":null,"id":1278156578,"size":2380531,"extension":"mp3","sr":44100,"dfsId":18594940650720470,"bitrate":96000,"playTime":198315,"volumeDelta":-3.49,"dfsId_str":"18594940650720470"},"bMusic":{"name":null,"id":1278156578,"size":2380531,"extension":"mp3","sr":44100,"dfsId":18594940650720470,"bitrate":96000,"playTime":198315,"volumeDelta":-3.49,"dfsId_str":"18594940650720470"},"mp3Url":"http://m2.music.126.net/a7SbFX7CDQGxidZEZmw_BQ==/18594940650720470.mp3","mvid":5438086,"rtype":0,"rurl":null}]
     * equalizers : {}
     * code : 200
     */

    private EqualizersBean equalizers;
    private int code;
    private List<SongsBean> songs;

    public EqualizersBean getEqualizers() {
        return equalizers;
    }

    public void setEqualizers(EqualizersBean equalizers) {
        this.equalizers = equalizers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public static class EqualizersBean {
    }

    public static class SongsBean implements Parcelable{
        /**
         * name : 我们万岁
         * id : 456175812
         * position : 1
         * alias : []
         * status : 0
         * fee : 8
         * copyrightId : 15001
         * disc :
         * no : 1
         * artists : [{"name":"BBF","id":12139308,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
         * album : {"name":"我们万岁 (庆功版)","id":35158222,"type":"专辑","size":12,"picId":18502581673986781,"blurPicUrl":"http://p3.music.126.net/fUqUwYisQBKMV3Qx1yEatQ==/18502581673986781.jpg","companyId":0,"pic":18502581673986781,"picUrl":"http://p4.music.126.net/fUqUwYisQBKMV3Qx1yEatQ==/18502581673986781.jpg","publishTime":1486310400007,"description":"","tags":"","company":"简单快乐","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":3,"copyrightId":15001,"commentThreadId":"R_AL_3_35158222","artists":[{"name":"BBF","id":12139308,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":"录音室版","picId_str":"18502581673986781"}
         * starred : false
         * popularity : 95
         * score : 95
         * starredNum : 0
         * duration : 198315
         * playedNum : 0
         * dayPlays : 0
         * hearTime : 0
         * ringtone : null
         * crbt : null
         * audition : null
         * copyFrom :
         * commentThreadId : R_SO_4_456175812
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * copyright : 2
         * hMusic : {"name":null,"id":1278156576,"size":7934999,"extension":"mp3","sr":44100,"dfsId":18644418673971033,"bitrate":320000,"playTime":198315,"volumeDelta":-3.82,"dfsId_str":"18644418673971033"}
         * mMusic : {"name":null,"id":1278156577,"size":3967522,"extension":"mp3","sr":44100,"dfsId":18733479115821694,"bitrate":160000,"playTime":198315,"volumeDelta":-3.44,"dfsId_str":"18733479115821694"}
         * lMusic : {"name":null,"id":1278156578,"size":2380531,"extension":"mp3","sr":44100,"dfsId":18594940650720470,"bitrate":96000,"playTime":198315,"volumeDelta":-3.49,"dfsId_str":"18594940650720470"}
         * bMusic : {"name":null,"id":1278156578,"size":2380531,"extension":"mp3","sr":44100,"dfsId":18594940650720470,"bitrate":96000,"playTime":198315,"volumeDelta":-3.49,"dfsId_str":"18594940650720470"}
         * mp3Url : http://m2.music.126.net/a7SbFX7CDQGxidZEZmw_BQ==/18594940650720470.mp3
         * mvid : 5438086
         * rtype : 0
         * rurl : null
         */

        private String name;
        private int id;
        private int position;
        private int status;
        private int fee;
        private int copyrightId;
        private String disc;
        private int no;
        private AlbumBean album;
        private boolean starred;
        private int popularity;
        private int score;
        private int starredNum;
        private int duration;
        private int playedNum;
        private int dayPlays;
        private int hearTime;
        private Object ringtone;
        private Object crbt;
        private Object audition;
        private String copyFrom;
        private String commentThreadId;
        private Object rtUrl;
        private int ftype;
        private int copyright;
        private HMusicBean hMusic;
        private MMusicBean mMusic;
        private LMusicBean lMusic;
        private BMusicBean bMusic;
        private String mp3Url;
        private int mvid;
        private int rtype;
        private Object rurl;
        private List<?> alias;
        private List<ArtistsBeanX> artists;
        private List<?> rtUrls;

        protected SongsBean(Parcel in) {
            name = in.readString();
            id = in.readInt();
            position = in.readInt();
            status = in.readInt();
            fee = in.readInt();
            copyrightId = in.readInt();
            disc = in.readString();
            no = in.readInt();
            starred = in.readByte() != 0;
            popularity = in.readInt();
            score = in.readInt();
            starredNum = in.readInt();
            duration = in.readInt();
            playedNum = in.readInt();
            dayPlays = in.readInt();
            hearTime = in.readInt();
            copyFrom = in.readString();
            commentThreadId = in.readString();
            ftype = in.readInt();
            copyright = in.readInt();
            mp3Url = in.readString();
            mvid = in.readInt();
            rtype = in.readInt();
        }

        public static final Creator<SongsBean> CREATOR = new Creator<SongsBean>() {
            @Override
            public SongsBean createFromParcel(Parcel in) {
                return new SongsBean(in);
            }

            @Override
            public SongsBean[] newArray(int size) {
                return new SongsBean[size];
            }
        };

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getCopyrightId() {
            return copyrightId;
        }

        public void setCopyrightId(int copyrightId) {
            this.copyrightId = copyrightId;
        }

        public String getDisc() {
            return disc;
        }

        public void setDisc(String disc) {
            this.disc = disc;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public boolean isStarred() {
            return starred;
        }

        public void setStarred(boolean starred) {
            this.starred = starred;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getStarredNum() {
            return starredNum;
        }

        public void setStarredNum(int starredNum) {
            this.starredNum = starredNum;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlayedNum() {
            return playedNum;
        }

        public void setPlayedNum(int playedNum) {
            this.playedNum = playedNum;
        }

        public int getDayPlays() {
            return dayPlays;
        }

        public void setDayPlays(int dayPlays) {
            this.dayPlays = dayPlays;
        }

        public int getHearTime() {
            return hearTime;
        }

        public void setHearTime(int hearTime) {
            this.hearTime = hearTime;
        }

        public Object getRingtone() {
            return ringtone;
        }

        public void setRingtone(Object ringtone) {
            this.ringtone = ringtone;
        }

        public Object getCrbt() {
            return crbt;
        }

        public void setCrbt(Object crbt) {
            this.crbt = crbt;
        }

        public Object getAudition() {
            return audition;
        }

        public void setAudition(Object audition) {
            this.audition = audition;
        }

        public String getCopyFrom() {
            return copyFrom;
        }

        public void setCopyFrom(String copyFrom) {
            this.copyFrom = copyFrom;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public Object getRtUrl() {
            return rtUrl;
        }

        public void setRtUrl(Object rtUrl) {
            this.rtUrl = rtUrl;
        }

        public int getFtype() {
            return ftype;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
        }

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public HMusicBean getHMusic() {
            return hMusic;
        }

        public void setHMusic(HMusicBean hMusic) {
            this.hMusic = hMusic;
        }

        public MMusicBean getMMusic() {
            return mMusic;
        }

        public void setMMusic(MMusicBean mMusic) {
            this.mMusic = mMusic;
        }

        public LMusicBean getLMusic() {
            return lMusic;
        }

        public void setLMusic(LMusicBean lMusic) {
            this.lMusic = lMusic;
        }

        public BMusicBean getBMusic() {
            return bMusic;
        }

        public void setBMusic(BMusicBean bMusic) {
            this.bMusic = bMusic;
        }

        public String getMp3Url() {
            return mp3Url;
        }

        public void setMp3Url(String mp3Url) {
            this.mp3Url = mp3Url;
        }

        public int getMvid() {
            return mvid;
        }

        public void setMvid(int mvid) {
            this.mvid = mvid;
        }

        public int getRtype() {
            return rtype;
        }

        public void setRtype(int rtype) {
            this.rtype = rtype;
        }

        public Object getRurl() {
            return rurl;
        }

        public void setRurl(Object rurl) {
            this.rurl = rurl;
        }

        public List<?> getAlias() {
            return alias;
        }

        public void setAlias(List<?> alias) {
            this.alias = alias;
        }

        public List<ArtistsBeanX> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBeanX> artists) {
            this.artists = artists;
        }

        public List<?> getRtUrls() {
            return rtUrls;
        }

        public void setRtUrls(List<?> rtUrls) {
            this.rtUrls = rtUrls;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeInt(id);
            dest.writeInt(position);
            dest.writeInt(status);
            dest.writeInt(fee);
            dest.writeInt(copyrightId);
            dest.writeString(disc);
            dest.writeInt(no);
            dest.writeByte((byte) (starred ? 1 : 0));
            dest.writeInt(popularity);
            dest.writeInt(score);
            dest.writeInt(starredNum);
            dest.writeInt(duration);
            dest.writeInt(playedNum);
            dest.writeInt(dayPlays);
            dest.writeInt(hearTime);
            dest.writeString(copyFrom);
            dest.writeString(commentThreadId);
            dest.writeInt(ftype);
            dest.writeInt(copyright);
            dest.writeString(mp3Url);
            dest.writeInt(mvid);
            dest.writeInt(rtype);
        }

        public static class AlbumBean {
            /**
             * name : 我们万岁 (庆功版)
             * id : 35158222
             * type : 专辑
             * size : 12
             * picId : 18502581673986781
             * blurPicUrl : http://p3.music.126.net/fUqUwYisQBKMV3Qx1yEatQ==/18502581673986781.jpg
             * companyId : 0
             * pic : 18502581673986781
             * picUrl : http://p4.music.126.net/fUqUwYisQBKMV3Qx1yEatQ==/18502581673986781.jpg
             * publishTime : 1486310400007
             * description :
             * tags :
             * company : 简单快乐
             * briefDesc :
             * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}
             * songs : []
             * alias : []
             * status : 3
             * copyrightId : 15001
             * commentThreadId : R_AL_3_35158222
             * artists : [{"name":"BBF","id":12139308,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
             * subType : 录音室版
             * picId_str : 18502581673986781
             */

            private String name;
            private int id;
            private String type;
            private int size;
            private long picId;
            private String blurPicUrl;
            private int companyId;
            private long pic;
            private String picUrl;
            private long publishTime;
            private String description;
            private String tags;
            private String company;
            private String briefDesc;
            private ArtistBean artist;
            private int status;
            private int copyrightId;
            private String commentThreadId;
            private String subType;
            private String picId_str;
            private List<?> songs;
            private List<?> alias;
            private List<ArtistsBean> artists;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getBlurPicUrl() {
                return blurPicUrl;
            }

            public void setBlurPicUrl(String blurPicUrl) {
                this.blurPicUrl = blurPicUrl;
            }

            public int getCompanyId() {
                return companyId;
            }

            public void setCompanyId(int companyId) {
                this.companyId = companyId;
            }

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public ArtistBean getArtist() {
                return artist;
            }

            public void setArtist(ArtistBean artist) {
                this.artist = artist;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public String getSubType() {
                return subType;
            }

            public void setSubType(String subType) {
                this.subType = subType;
            }

            public String getPicId_str() {
                return picId_str;
            }

            public void setPicId_str(String picId_str) {
                this.picId_str = picId_str;
            }

            public List<?> getSongs() {
                return songs;
            }

            public void setSongs(List<?> songs) {
                this.songs = songs;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public static class ArtistBean {
                /**
                 * name :
                 * id : 0
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 */

                private String name;
                private int id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private List<?> alias;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }

            public static class ArtistsBean {
                /**
                 * name : BBF
                 * id : 12139308
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 */

                private String name;
                private int id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private List<?> alias;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class HMusicBean {
            /**
             * name : null
             * id : 1278156576
             * size : 7934999
             * extension : mp3
             * sr : 44100
             * dfsId : 18644418673971033
             * bitrate : 320000
             * playTime : 198315
             * volumeDelta : -3.82
             * dfsId_str : 18644418673971033
             */

            private Object name;
            private int id;
            private int size;
            private String extension;
            private int sr;
            private long dfsId;
            private int bitrate;
            private int playTime;
            private double volumeDelta;
            private String dfsId_str;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public long getDfsId() {
                return dfsId;
            }

            public void setDfsId(long dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public double getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(double volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public String getDfsId_str() {
                return dfsId_str;
            }

            public void setDfsId_str(String dfsId_str) {
                this.dfsId_str = dfsId_str;
            }
        }

        public static class MMusicBean {
            /**
             * name : null
             * id : 1278156577
             * size : 3967522
             * extension : mp3
             * sr : 44100
             * dfsId : 18733479115821694
             * bitrate : 160000
             * playTime : 198315
             * volumeDelta : -3.44
             * dfsId_str : 18733479115821694
             */

            private Object name;
            private int id;
            private int size;
            private String extension;
            private int sr;
            private long dfsId;
            private int bitrate;
            private int playTime;
            private double volumeDelta;
            private String dfsId_str;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public long getDfsId() {
                return dfsId;
            }

            public void setDfsId(long dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public double getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(double volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public String getDfsId_str() {
                return dfsId_str;
            }

            public void setDfsId_str(String dfsId_str) {
                this.dfsId_str = dfsId_str;
            }
        }

        public static class LMusicBean {
            /**
             * name : null
             * id : 1278156578
             * size : 2380531
             * extension : mp3
             * sr : 44100
             * dfsId : 18594940650720470
             * bitrate : 96000
             * playTime : 198315
             * volumeDelta : -3.49
             * dfsId_str : 18594940650720470
             */

            private Object name;
            private int id;
            private int size;
            private String extension;
            private int sr;
            private long dfsId;
            private int bitrate;
            private int playTime;
            private double volumeDelta;
            private String dfsId_str;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public long getDfsId() {
                return dfsId;
            }

            public void setDfsId(long dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public double getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(double volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public String getDfsId_str() {
                return dfsId_str;
            }

            public void setDfsId_str(String dfsId_str) {
                this.dfsId_str = dfsId_str;
            }
        }

        public static class BMusicBean {
            /**
             * name : null
             * id : 1278156578
             * size : 2380531
             * extension : mp3
             * sr : 44100
             * dfsId : 18594940650720470
             * bitrate : 96000
             * playTime : 198315
             * volumeDelta : -3.49
             * dfsId_str : 18594940650720470
             */

            private Object name;
            private int id;
            private int size;
            private String extension;
            private int sr;
            private long dfsId;
            private int bitrate;
            private int playTime;
            private double volumeDelta;
            private String dfsId_str;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public long getDfsId() {
                return dfsId;
            }

            public void setDfsId(long dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public double getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(double volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public String getDfsId_str() {
                return dfsId_str;
            }

            public void setDfsId_str(String dfsId_str) {
                this.dfsId_str = dfsId_str;
            }
        }

        public static class ArtistsBeanX {
            /**
             * name : BBF
             * id : 12139308
             * picId : 0
             * img1v1Id : 0
             * briefDesc :
             * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * img1v1Url : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * albumSize : 0
             * alias : []
             * trans :
             * musicSize : 0
             */

            private String name;
            private int id;
            private int picId;
            private int img1v1Id;
            private String briefDesc;
            private String picUrl;
            private String img1v1Url;
            private int albumSize;
            private String trans;
            private int musicSize;
            private List<?> alias;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }

            public int getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(int img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }
}
