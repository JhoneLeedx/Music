package com.jhonlee.music.network.api;

import com.jhonlee.music.pojo.Token;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public interface IQQMusicRq {
    /*榜行榜id
    3=欧美
    5=内地
    6=港台
    16=韩国
    17=日本
    18=民谣
    19=摇滚
    23=销量
    26=热歌*/
    @GET("213-4")
    Observable<Token> getListMenus(@Query("topid") int topid,@Query("showapi_appid")String appid,@Query("showapi_sign")String appscert);

    @GET("213-1")
    Observable<Token> getSong(@Query("keyword") int keyword,@Query("page")int page,@Query("showapi_appid")String appid,@Query("showapi_sign")String appscert);

    @GET("213-2")
    Observable<Token> getSongLic(@Query("musicid")int id,@Query("showapi_appid")String appid,@Query("showapi_sign")String appscert);
}
