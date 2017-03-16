package com.jhonlee.music.mvp.presenter;

import com.google.gson.Gson;
import com.jhonlee.music.mvp.contract.MenuContract;
import com.jhonlee.music.mvp.contract.PlayerContract;
import com.jhonlee.music.network.NetworkApi;
import com.jhonlee.music.pojo.Player;
import com.jhonlee.music.pojo.SongMenu;
import com.jhonlee.music.pojo.Token;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class PlayerPresenterImpl implements PlayerContract.Presenter{

    private PlayerContract.View view;

    @Override
    public void loadPlayers(String search, int type, int offset) {
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
                            Player player = gson.fromJson(json,Player.class);
                            view.showPlayers(player.getArtists());
                        }
                    }
                });
    }

    @Override
    public void attachView(PlayerContract.View view) {
        this.view = view;
    }
}
