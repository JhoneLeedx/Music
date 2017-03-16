package com.jhonlee.music.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.jhonlee.music.mvp.contract.DetailContract;
import com.jhonlee.music.network.NetworkApi;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.Token;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View view;

    @Override
    public void showSongMenuDetail(int id) {
        view.showProgress();
        Observable<Token> observable = NetworkApi.getNetworkApi().getImusic().getSongMenuDetials(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Log.d("执行到这了、、、、","onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("错误代码、、、、",e.getMessage());
                    }

                    @Override
                    public void onNext(Token token) {
                        Log.d("执行到这了、、、、","onNext(Token token)");
                        view.disProgress();
                        if (token.getCode()==200){
                            Gson gson = new Gson();
                            String json = gson.toJson(token.getResult());
                            SongMenuDetail menuDetail = gson.fromJson(json,SongMenuDetail.class);
                            view.showSongMenuDetail(menuDetail.getTracks());
                        }
                    }
                });
    }

    @Override
    public void attachView(DetailContract.View view) {
        this.view = view;
    }
}
