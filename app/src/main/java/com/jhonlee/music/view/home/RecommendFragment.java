package com.jhonlee.music.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.music.R;
import com.jhonlee.music.listener.MenuClickListener;
import com.jhonlee.music.mvp.contract.MenuContract;
import com.jhonlee.music.mvp.contract.PlayerContract;
import com.jhonlee.music.mvp.presenter.PlayerPresenterImpl;
import com.jhonlee.music.mvp.presenter.SongMenuPresenterImpl;
import com.jhonlee.music.pojo.Artist;
import com.jhonlee.music.pojo.PlayList;
import com.jhonlee.music.util.Dip2pxUtil;
import com.jhonlee.music.view.detail.PlayListDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class RecommendFragment extends Fragment implements PlayerContract.View, MenuContract.View, MenuClickListener {

    @BindView(R.id.rollpager)
    ViewPager lunboImg;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.linear)
    LinearLayout linear;

    private LunBoAdapter adapter;
    private RecommendAdapter radapter;

    private int currentIndex = 0;
    private List<View> views;
    private List<String> urls;
    private List<PlayList> playLists;

    private PlayerContract.Presenter presenter;
    private MenuContract.Presenter mpresenter;

    private int loadmoreIndex = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter = new PlayerPresenterImpl();
        presenter.attachView(this);
        presenter.loadPlayers("歌手", 100, 1);

        mpresenter = new SongMenuPresenterImpl();
        mpresenter.attachView(this);
        mpresenter.loadMenus("推荐", 1000, 0);

        urls = new ArrayList<String>();
        views = new ArrayList<View>();

        playLists = new ArrayList<PlayList>();
        radapter = new RecommendAdapter(playLists, getContext(), this);

        initRecycler();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initRecycler() {

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(radapter);




        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mpresenter.loadMenus("推荐", 1000, 1);
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
                        mpresenter.showMore("精选",1000,loadmoreIndex);
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

    private void initLunbo(List<String> list) {
        views.clear();
        linear.removeAllViews();
        for (String url : list) {
            TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.image_indicator_dot);
            textView.setWidth(Dip2pxUtil.dip2px(getContext(), 26));
            textView.setHeight(Dip2pxUtil.dip2px(getContext(), 26));
            textView.setPadding(Dip2pxUtil.dip2px(getContext(), 3), Dip2pxUtil.dip2px(getContext(), 3), Dip2pxUtil.dip2px(getContext(), 3), Dip2pxUtil.dip2px(getContext(), 3));
            linear.addView(textView);
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(getContext()).load(url).into(imageView);
            views.add(imageView);
        }
        adapter = new LunBoAdapter(views);
        lunboImg.setAdapter(adapter);
        //轮播
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentIndex++;
                handler.sendEmptyMessage(0);
                handler.postDelayed(this, 5000);
            }
        }, 5000);
        //轮播时 图片移动动画
        lunboImg.setPageTransformer(true, new ViewPager.PageTransformer() {
            private float MIN_SCALE = 0.85f;

            private float MIN_ALPHA = 0.5f;

            @Override
            public void transformPage(View view, float position) {
                int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) {
                    view.setAlpha(0);
                } else if (position <= 1) {
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                    view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE)
                            / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                } else {
                    view.setAlpha(0);
                }
            }
        });

        //当前图片选中时
        lunboImg.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //更新界面的效果
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (currentIndex == views.size()) {
                currentIndex = 0;
            }
            lunboImg.setCurrentItem(currentIndex);
            for (int i = 0; i < linear.getChildCount(); i++) {

                TextView textView = (TextView) linear.getChildAt(i);
                if (currentIndex == i) {
                    textView.setBackgroundResource(R.drawable.image_indicator_dot_focus);
                } else {
                    textView.setBackgroundResource(R.drawable.image_indicator_dot);
                }
                final int finalI = i;
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //lunboImg.setCurrentItem(finalI);
                        currentIndex = finalI;
                        handler.sendEmptyMessage(0);
                    }
                });

            }
        }
    };

    @Override
    public void showPlayers(List<Artist> list) {
        urls.clear();
        if (list != null && list.size() > 0) {
            for (Artist artist : list) {
                urls.add(artist.getImg1v1Url());
            }
            initLunbo(urls);
            handler.sendEmptyMessage(0);
        }
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
