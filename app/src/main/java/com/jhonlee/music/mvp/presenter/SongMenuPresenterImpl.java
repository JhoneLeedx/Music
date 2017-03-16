package com.jhonlee.music.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.jhonlee.music.mvp.contract.MenuContract;
import com.jhonlee.music.network.NetworkApi;
import com.jhonlee.music.pojo.SongMenu;
import com.jhonlee.music.pojo.Token;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class SongMenuPresenterImpl implements MenuContract.Presenter{

    private MenuContract.View view;

    @Override
    public void attachView(MenuContract.View view) {
        this.view = view;
    }

    @Override
    public void loadMenus(String search, int type, int offset) {
        Observable<Token> observable = NetworkApi.getNetworkApi().getImusic().getSongMenus(search,type,offset);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Token token) {

                        if (token.getCode()==200){
                            Gson gson = new Gson();
                            String json = gson.toJson(token.getResult());
                            SongMenu songMenu = gson.fromJson(json,SongMenu.class);
                            view.showSongMenus(songMenu.getPlaylists());
                        }
                    }
                });
    }

    @Override
    public void showMore(String search, int type, int offset) {
        Observable<Token> observable = NetworkApi.getNetworkApi().getImusic().getSongMenus(search,type,offset);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Token token) {

                        if (token.getCode()==200){
                            Gson gson = new Gson();
                            String json = gson.toJson(token.getResult());
                            SongMenu songMenu = gson.fromJson(json,SongMenu.class);
                            view.showMore(songMenu.getPlaylists());
                        }
                    }
                });
    }
}
