package com.jhonlee.music.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhonlee.music.R;
import com.jhonlee.music.listener.MenuClickListener;
import com.jhonlee.music.mvp.contract.MenuContract;
import com.jhonlee.music.mvp.presenter.SongMenuPresenterImpl;
import com.jhonlee.music.pojo.PlayList;
import com.jhonlee.music.view.detail.PlayListDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public class TypeFragment extends Fragment implements  MenuContract.View, MenuClickListener {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private RecommendAdapter radapter;
    private MenuContract.Presenter mpresenter;
    private List<PlayList> playLists;
    private int loadmoreIndex = 0;

    private String mType;

    public TypeFragment(String mType) {
        this.mType = mType;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jp, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        initDataAndView();
    }

    private void initDataAndView(){

        mpresenter = new SongMenuPresenterImpl();
        mpresenter.attachView(this);
        mpresenter.loadMenus(mType, 1000, 0);
        playLists = new ArrayList<PlayList>();
        radapter = new RecommendAdapter(playLists, getContext(), this);

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(radapter);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mpresenter.loadMenus(mType, 1000, 0);
                refresh.setRefreshing(false);
            }
        });
        recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int lastPosition = -1;
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 获取最后一个完全显示的item position
                    lastPosition = gridLayoutManager.findLastVisibleItemPosition();
                    if(lastPosition == recyclerView.getLayoutManager().getItemCount()-1){
                        loadmoreIndex++;
                        mpresenter.showMore(mType,1000,loadmoreIndex);
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void showSongMenus(List<PlayList> list) {
        playLists.clear();
        playLists.addAll(list);
        radapter.notifyDataSetChanged();
    }

    @Override
    public void showMore(List<PlayList> list) {
        if (list.size() > 0) {
            playLists.addAll(list);
            radapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showDetail(String url, int id, String title) {
        Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
