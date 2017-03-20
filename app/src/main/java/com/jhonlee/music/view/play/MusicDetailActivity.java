package com.jhonlee.music.view.play;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.music.R;
import com.jhonlee.music.listener.LyricListener;
import com.jhonlee.music.mvp.contract.SongContract;
import com.jhonlee.music.mvp.presenter.SongPresenterImpl;
import com.jhonlee.music.pojo.Lyric;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.SongToken;
import com.jhonlee.music.util.MusicUtil;
import com.jhonlee.music.wedget.LrcView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public class MusicDetailActivity extends AppCompatActivity implements SongContract.View {


    @BindView(R.id.tv_previous)
    TextView tvPrevious;
    @BindView(R.id.tv_play_pause)
    TextView tvPlayPause;
    @BindView(R.id.tv_next)
    TextView tvNext;
    @BindView(R.id.tv_time_t)
    TextView tvTimeT;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tv_time_all)
    TextView tvTimeAll;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_music_ablum)
    ImageView ivMusicAblum;
    @BindView(R.id.frame)
    FrameLayout frameLayout;

    private SongMenuDetail.TracksBean mTrack;
    private PlayMusciReceiver preceiver;
    private SongContract.Presenter presenter;

    private boolean flag;
    private LrcView lrcView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        ButterKnife.bind(this);
        mTrack = getIntent().getParcelableExtra("track");
        toolbar.setTitle(mTrack.getName());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter = new SongPresenterImpl();
        presenter.attachView(this);
        if (mTrack!=null){
            String ids = new StringBuffer().append("[").append(mTrack.getId()).append("]").toString();
            presenter.showSong(mTrack.getId(), ids);
            presenter.showSongLyric(mTrack.getId());
        }
        preceiver = new PlayMusciReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("getDuration");
        filter.addAction("upadateSeekbar");
        filter.addAction("updateMusic");
        filter.addAction("isplay");
        registerReceiver(preceiver, filter);
        initView();
    }

    @OnClick({R.id.tv_previous, R.id.tv_play_pause, R.id.tv_next})
    public void Click(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tv_previous:
                intent.setAction("MusicPrevious");
                lyricHandler.sendEmptyMessage(0);
                break;
            case R.id.tv_play_pause:
                if (flag) {
                    intent.setAction("MusicPause");
                } else {
                    intent.setAction("MusicPlay");
                }
                break;
            case R.id.tv_next:
                intent.setAction("MusicNext");
                lyricHandler.sendEmptyMessage(0);
                break;
        }
        sendBroadcast(intent);
    }


    private void initView() {

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    Intent intent = new Intent();
                    intent.setAction("seekbar");
                    intent.putExtra("progress", progress);
                    sendBroadcast(intent);
                    if (lrcView!=null){
                        lrcView.refreshLcy();
                        lrcView.updateTime(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(preceiver);
    }

    @Override
    public void showSong(SongToken.SongsBean song) {
        if (song != null) {
            Message message = new Message();
            message.obj = song;
            handler.sendMessage(message);
        }
    }

    @Override
    public void showSongLyric(List<Lyric> lyrics) {
        if (lyrics.size()>0){
            for (Lyric l : lyrics)
                Log.d("歌词", "" + l.getTime() + ":" + l.getLyric());
            Message message = new Message();
            message.obj = lyrics;
            message.what = 1;
            lyricHandler.sendMessage(message);
        }else {
            lyricHandler.sendEmptyMessage(0);
        }

    }

    private class PlayMusciReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("upadateSeekbar")) {
                int currentTime = intent.getIntExtra("currentTime", 0);
                seekBar.setProgress(currentTime);
                tvTimeT.setText(MusicUtil.formatTime(currentTime));
                if (lrcView!=null){
                    lrcView.updateTime(currentTime);
                }

            } else if (action.equals("getDuration")) {
                int allTime = intent.getIntExtra("duration", 0);
                flag = intent.getBooleanExtra("isplay", false);
                if (allTime != 0) {
                    seekBar.setMax(allTime);
                    tvTimeAll.setText(MusicUtil.formatTime(allTime));

                }
                playOrPause.sendEmptyMessage(0);
            } else if (action.equals("updateMusic")) {
                SongMenuDetail.TracksBean track = intent.getParcelableExtra("track");
                String ids = new StringBuffer().append("[").append(track.getId()).append("]").toString();
                presenter.showSong(track.getId(), ids);
                presenter.showSongLyric(track.getId());
            } else if (action.equals("isplay")) {
                flag = intent.getBooleanExtra("isplay", false);
                playOrPause.sendEmptyMessage(0);
            }
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SongToken.SongsBean song = (SongToken.SongsBean) msg.obj;
            toolbar.setTitle(song.getName());
            if (song.getAlbum() != null) {
                Animation rote = AnimationUtils.loadAnimation(MusicDetailActivity.this, R.anim.img_anim);
                rote.setRepeatCount(-1);//一直循环
                rote.setDuration(10000);
                Glide.with(MusicDetailActivity.this)
                        .load(song.getAlbum().getPicUrl())
                        .animate(rote)
                        .bitmapTransform(new CropCircleTransformation(MusicDetailActivity.this))
                        .into(ivMusicAblum);
            }
            Intent i = new Intent();
            i.setAction("startMusic");
            i.putExtra("url", song.getMp3Url());
            i.putExtra("imgUrl",song.getAlbum().getPicUrl());
            i.putExtra("name",song.getName());
            i.putExtra("author",song.getArtists().get(0).getName());
            sendBroadcast(i);
        }
    };
    private Handler playOrPause = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (flag) {
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_pause_white_36dp);
                    // 这一步必须要做,否则不会显示.
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvPlayPause.setCompoundDrawables(null, drawable, null, null);
                } else {
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_play_white_36dp);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvPlayPause.setCompoundDrawables(null, drawable, null, null);
                }
            }
        }
    };

    private Handler lyricHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                remoView();
            }else if (msg.what == 1){
                List<Lyric> list = (List<Lyric>) msg.obj;
                     remoView();
                if (list.size()>0){
                    lrcView = new LrcView(getBaseContext(),list);
                    frameLayout.addView(lrcView);//lrcview.setLyric(list);
                }
            }

        }
    };
    private void remoView(){
        if (lrcView!=null)
            frameLayout.removeView(lrcView);
    }
}
