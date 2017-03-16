package com.jhonlee.music.pojo;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class SongMenu {


        /**
         * playlists : [{"id":554473977,"name":"2016年度最热新歌TOP100","coverImgUrl":"http://p3.music.126.net/jIpqVAUvtZpTBUe8LDedlA==/18778559092465830.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":100,"userId":1,"playCount":13151834,"bookCount":214894,"highQuality":false},{"id":588042413,"name":"2017年一月最热新歌TOP50","coverImgUrl":"http://p3.music.126.net/M-_n7_aAYxiK8qQHYu5nhA==/18811544441381717.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":50,"userId":1,"playCount":5422853,"bookCount":60466,"highQuality":false},{"id":550808064,"name":"【环球唱片精选】2016最热欧美新歌Top100","coverImgUrl":"http://p3.music.126.net/af9zikWMlImWIEx7KwwGiw==/18537766045982072.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":100,"userId":1,"playCount":4574017,"bookCount":101010,"highQuality":false},{"id":616144102,"name":"2017年二月最热新歌TOP50","coverImgUrl":"http://p4.music.126.net/Xmp5IgZB8Zms76sgNwdTsg==/109951162868760982.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":50,"userId":1,"playCount":2785219,"bookCount":34990,"highQuality":false},{"id":476036938,"name":"2016年九月最热新歌TOP50","coverImgUrl":"http://p4.music.126.net/wy6WVRO0DX0T08ybCKjOyA==/1384285155410582.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":48,"userId":1,"playCount":2911860,"bookCount":16947,"highQuality":false},{"id":372640644,"name":"2016年四月最热新歌TOP50","coverImgUrl":"http://p3.music.126.net/KN0fyJQYM1wybC5MIN_BJQ==/1380986612775117.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":50,"userId":1,"playCount":1275889,"bookCount":5374,"highQuality":false},{"id":8827357,"name":"近几年好听的华语新歌","coverImgUrl":"http://p4.music.126.net/lh_2V_8z8m-rYeNxyGajGA==/5965950092358290.jpg","creator":{"nickname":"方-萌","userId":2680031,"userType":0,"authStatus":0},"subscribed":false,"trackCount":93,"userId":2680031,"playCount":980879,"bookCount":10885,"highQuality":false},{"id":134695023,"name":"2015年度摇滚&民谣&独立艺人最佳新歌","coverImgUrl":"http://p3.music.126.net/apQ6kTH6UPvirMNETfFWaQ==/3242459794047691.jpg","creator":{"nickname":"果酱音乐","userId":60370317,"userType":1,"authStatus":1},"subscribed":false,"trackCount":49,"userId":60370317,"playCount":1800040,"bookCount":27195,"highQuality":false},{"id":376223989,"name":"♪《十年》，那些老去的新歌™","coverImgUrl":"http://p4.music.126.net/t1A-DN7YjZfXDs29-uAMgw==/3438172866831568.jpg","creator":{"nickname":"Leo尘一","userId":253377539,"userType":0,"authStatus":0},"subscribed":false,"trackCount":202,"userId":253377539,"playCount":1626058,"bookCount":23335,"highQuality":false},{"id":120125151,"name":"2015年度盘点 | 欧美最热洗脑新歌推荐","coverImgUrl":"http://p4.music.126.net/9Yp7CFSTibzdfc8cs0WFlw==/3294136838638916.jpg","creator":{"nickname":"音乐分享达人","userId":613323,"userType":0,"authStatus":0},"subscribed":false,"trackCount":100,"userId":613323,"playCount":1603212,"bookCount":22563,"highQuality":false}]
         * playlistCount : 200
         */
        private int playlistCount;
        private List<PlayList> playlists;

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public List<PlayList> getPlaylists() {
            return playlists;
        }

        public void setPlaylists(List<PlayList> playlists) {
            this.playlists = playlists;
        }

}
