package com.jhonlee.music.mvp.contract;

import com.jhonlee.music.mvp.presenter.BasePresenter;
import com.jhonlee.music.mvp.view.BaseView;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.SongToken;

/**
 * Created by JhoneLee on 2017/3/17.
 */

public interface SongContract {

    interface View extends BaseView {

        void showSong(SongToken.SongsBean song);
    }

    interface Presenter extends BasePresenter<View> {

        void showSong(int id,String ids);
    }
}
