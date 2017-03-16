package com.jhonlee.music.mvp.contract;

import com.jhonlee.music.mvp.presenter.BasePresenter;
import com.jhonlee.music.mvp.view.BaseView;
import com.jhonlee.music.pojo.Artist;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public interface PlayerContract {

    interface View extends BaseView {

        void showPlayers(List<Artist> list);
    }
    interface Presenter extends BasePresenter<View> {

        void loadPlayers(String search, int type, int offset);
    }

}
