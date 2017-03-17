package com.jhonlee.music.view.detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.music.R;
import com.jhonlee.music.mvp.contract.SongContract;
import com.jhonlee.music.mvp.presenter.SongPresenterImpl;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.pojo.SongToken;
import com.jhonlee.music.util.Const;
import com.jhonlee.music.util.MusicUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public class MusicDetailActivity extends AppCompatActivity implements SongContract.View{


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

    private SongMenuDetail.TracksBean mTrack;
    private PlayMusciReceiver preceiver;
    private SongContract.Presenter presenter;

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
        if (item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();


        presenter = new SongPresenterImpl();
        presenter.attachView(this);
        String ids = new StringBuffer().append("[").append(mTrack.getId()).append("]").toString();
        presenter.showSong(mTrack.getId(),ids);

        preceiver = new PlayMusciReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("getDuration");
        filter.addAction("upadateSeekbar");
        filter.addAction("updateMusic");
        registerReceiver(preceiver,filter);
        initView();
    }
    private void initView(){



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    Intent intent = new Intent();
                    intent.setAction("com.jhonlee.music.seekbar");
                    //intent.putExtra("state", Const.STATE_SEEK);
                    intent.putExtra("progress", progress);
                    sendBroadcast(intent);
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
        if (song!=null){
            Message message = new Message();
            message.obj = song;
            handler.sendMessage(message);
        }
    }

    private class PlayMusciReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("upadateSeekbar")){
                int currentTime = intent.getIntExtra("currentTime",0);
                seekBar.setProgress(currentTime);
                tvTimeT.setText(MusicUtil.formatTime(currentTime));
            }else if (action.equals("getDuration")){
                int allTime = intent.getIntExtra("duration",0);
                if (allTime!=0){
                    seekBar.setMax(allTime);
                    tvTimeAll.setText(MusicUtil.formatTime(allTime));

                }
            }else if (action.equals("updateMusic")){
                SongMenuDetail.TracksBean track = intent.getParcelableExtra("track");
                String ids = new StringBuffer().append("[").append(track.getId()).append("]").toString();
                presenter.showSong(track.getId(),ids);
            }
        }
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SongToken.SongsBean song = (SongToken.SongsBean) msg.obj;
            toolbar.setTitle(song.getName());
            if (song.getAlbum()!=null){
                Animation rote =AnimationUtils.loadAnimation(MusicDetailActivity.this,R.anim.img_anim);
                rote.setRepeatCount(song.getDuration()/10000);
                rote.setDuration(10000);
                Glide.with(MusicDetailActivity.this)
                        .load(song.getAlbum().getPicUrl())
                        .animate(rote)
                        .bitmapTransform(new CropCircleTransformation(MusicDetailActivity.this))
                        .into(ivMusicAblum);
            }
            Intent i = new Intent();
            i.setAction("startMusic");
            i.putExtra("url",song.getMp3Url());
            sendBroadcast(i);
        }
    };
}
