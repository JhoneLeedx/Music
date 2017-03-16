package com.jhonlee.music.network.api;

import com.jhonlee.music.pojo.Recommend;
import com.jhonlee.music.pojo.SongMenu;
import com.jhonlee.music.pojo.Token;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public interface IMusicRequest {

    //s：搜索的内容  offset：偏移量（分页用）  limit：获取的数量
    // type：搜索的类型 歌曲 1 专辑 10 歌手 100 歌单 1000 用户 1002 mv 1004 歌词 1006 主播电台 1009
    @POST("search/get/")
    Observable<Token> getSongMenus(@Query("s") String search, @Query("type") int type, @Query("offset") int offset);
    @POST("playlist/detail")
    Observable<Token> getSongMenuDetials(@Query("id") int id);
}
