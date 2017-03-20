package com.jhonlee.music.mvp.presenter;

import com.jhonlee.music.mvp.contract.SongContract;
import com.jhonlee.music.network.NetworkApi;
import com.jhonlee.music.pojo.Lyric;
import com.jhonlee.music.pojo.LyricToken;
import com.jhonlee.music.pojo.SongToken;
import com.jhonlee.music.util.MusicUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/17.
 */

public class SongPresenterImpl implements SongContract.Presenter {

    private SongContract.View view;

    @Override
    public void showSong(int id, String ids) {
        Observable<SongToken> observable = NetworkApi.getNetworkApi().getImusic().getSongDetial(id,ids);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SongToken>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(SongToken token) {
                        if (token.getCode()==200){
                            view.showSong(token.getSongs().get(0));
                        }
                    }
                });
    }

    @Override
    public void showSongLyric(int id) {
        Observable<LyricToken> observable = NetworkApi.getNetworkApi().getImusic().getSongLyric(id,-1,-1,-1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LyricToken>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(LyricToken token) {
                        if (token.getCode()==200){
                            String time = token.getLrc().getLyric();
                            List<Lyric> lyrics = MusicUtil.getLyrics(time);
                            view.showSongLyric(lyrics);
                        }
                    }
                });
    }

    @Override
    public void attachView(SongContract.View view) {
        this.view = view;
    }
}
