package com.jhonlee.music.view.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.jhonlee.music.R;
import com.jhonlee.music.listener.MusicItemListener;
import com.jhonlee.music.mvp.contract.DetailContract;
import com.jhonlee.music.mvp.presenter.DetailPresenter;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.view.play.MusicDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class PlayListDetailActivity extends AppCompatActivity implements DetailContract.View,MusicItemListener{

    @BindView(R.id.iv_music_detail)
    ImageView ivMusicDetail;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress)
    ProgressBar progress;

    private String mIurl;
    private int mId;
    private String mTitle;

    private List<SongMenuDetail.TracksBean> mList;
    private DetailAdapter adapter;
    private DetailContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_detail);
        ButterKnife.bind(this);

        mIurl = getIntent().getStringExtra("url");
        mId = getIntent().getIntExtra("id",0);
        mTitle = getIntent().getStringExtra("title");
        toolbar.setTitle(mTitle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Glide.with(this).load(mIurl).into(ivMusicDetail);
        initRecycler();
    }

    private void initRecycler(){

        presenter = new DetailPresenter();
        presenter.attachView(this);

        presenter.showSongMenuDetail(mId);

        progress.setVisibility(View.GONE);
        mList = new ArrayList<>();
        adapter = new DetailAdapter(mList,this,this);
        LinearLayoutManager manager =new  LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycler.setAdapter(adapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void disProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showSongMenuDetail(List<SongMenuDetail.TracksBean> list) {
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();

        ArrayList<String> musics = new ArrayList<String>();
        for (SongMenuDetail.TracksBean tracksBean : list){
            musics.add(tracksBean.getMp3Url());
        }
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) list);
        intent.putStringArrayListExtra("mp3Urls", musics);
        intent.setAction("getMp3Urls");
        sendBroadcast(intent);
    }

    @Override
    public void playItemMusic(SongMenuDetail.TracksBean track) {
        Intent intent = new Intent(this,MusicDetailActivity.class);
        intent.putExtra("track",track);
        startActivity(intent);
    }
}
