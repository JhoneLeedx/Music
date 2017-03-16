package com.jhonlee.music.mvp.contract;

import android.content.Context;

import com.jhonlee.music.mvp.presenter.BasePresenter;
import com.jhonlee.music.mvp.view.BaseView;
import com.jhonlee.music.pojo.Artist;
import com.jhonlee.music.pojo.PlayList;
import com.jhonlee.music.pojo.SongMenu;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public interface MenuContract {

    interface View extends BaseView {

        void showSongMenus(List<PlayList> list);

        void showMore(List<PlayList> list);
    }
    interface Presenter extends BasePresenter<View> {

        void loadMenus(String search,int type,int offset);

        void showMore(String search,int type,int offset);
    }

}
