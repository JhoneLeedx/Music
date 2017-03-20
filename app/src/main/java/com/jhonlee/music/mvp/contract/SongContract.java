package com.jhonlee.music.mvp.contract;

import com.jhonlee.music.mvp.presenter.BasePresenter;
import com.jhonlee.music.mvp.view.BaseView;
import com.jhonlee.music.pojo.Lyric;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.SongToken;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/17.
 */

public interface SongContract {

    interface View extends BaseView {

        void showSong(SongToken.SongsBean song);

        void showSongLyric(List<Lyric> lyrics);
    }

    interface Presenter extends BasePresenter<View> {

        void showSong(int id,String ids);
        void showSongLyric(int id);
    }
}
