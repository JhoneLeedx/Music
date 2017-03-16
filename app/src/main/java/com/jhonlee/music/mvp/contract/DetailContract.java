package com.jhonlee.music.mvp.contract;

import com.jhonlee.music.mvp.presenter.BasePresenter;
import com.jhonlee.music.mvp.view.BaseView;
import com.jhonlee.music.pojo.PlayList;
import com.jhonlee.music.pojo.SongMenuDetail;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public interface DetailContract  {

    interface View extends BaseView {
        void showProgress();
        void disProgress();
        void showSongMenuDetail(List<SongMenuDetail.TracksBean> list);

    }
    interface Presenter extends BasePresenter<DetailContract.View> {

        void showSongMenuDetail(int id);


    }
}
