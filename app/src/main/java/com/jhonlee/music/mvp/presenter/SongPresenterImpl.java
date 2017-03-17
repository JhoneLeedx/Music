package com.jhonlee.music.mvp.presenter;

import com.jhonlee.music.mvp.contract.SongContract;
import com.jhonlee.music.network.NetworkApi;
import com.jhonlee.music.pojo.SongToken;

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
    public void attachView(SongContract.View view) {
        this.view = view;
    }
}
