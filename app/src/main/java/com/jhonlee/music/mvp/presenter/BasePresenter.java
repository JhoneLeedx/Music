package com.jhonlee.music.mvp.presenter;

import com.jhonlee.music.mvp.view.BaseView;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

}
