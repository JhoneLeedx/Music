package com.jhonlee.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jhonlee.music.pojo.Music;
import com.jhonlee.music.util.Const;
import com.jhonlee.music.util.MusicUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JhoneLee on 2017/3/13.
 */

public class PlayActivity extends AppCompatActivity {

    @BindView(R.id.tv_previous)
    TextView tvPrevious;
    @BindView(R.id.tv_play_pause)
    TextView tvPlayPause;
    @BindView(R.id.tv_next)
    TextView tvNext;
   /* @BindView(R.id.tv_music_name)
    TextView tvMusicName;*/
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tv_time_t)
    TextView tvTimeT;
    @BindView(R.id.tv_time_all)
    TextView tvTimeAll;

    private boolean flag = false;
    private List<Music> musics;
    private Music music;
    private int index;
    private MusicReceiver receiver;
    private SeekBarReceiver seekBarReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        ButterKnife.bind(this);

        setSeekBarClick();
    }


    @OnClick({R.id.tv_previous, R.id.tv_play_pause, R.id.tv_next})
    public void Click(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tv_previous:
                intent.setAction("com.jhonlee.music.previous");
                intent.putExtra("state", Const.STATE_PREVIOUS);
                break;
            case R.id.tv_play_pause:
                if (flag) {
                    intent.setAction("com.jhonlee.music.pause");
                    intent.putExtra("state", Const.STATE_PAUSE);
                } else {
                    intent.setAction("com.jhonlee.music.play");
                    intent.putExtra("state", Const.STATE_PLAY);
                }
                break;
            case R.id.tv_next:
                intent.setAction("com.jhonlee.music.next");
                intent.putExtra("state", Const.STATE_NEXT);

                break;
        }
        intent.putExtra("index", index);
        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        musics = MusicUtil.getData(this);
        music = getIntent().getParcelableExtra("music");
        for (int i = 0; i < musics.size(); i++) {
            if (musics.get(i).getPath().equals(music.getPath())) {
                index = i;
            }
        }
        if (!flag) {

            Intent intent = new Intent();
            intent.setAction("com.jhonlee.music.play");
            intent.putExtra("state", Const.STATE_PLAY);
            intent.putExtra("index", index);
            sendBroadcast(intent);//点击进入时，直接播放
        }


        receiver = new MusicReceiver();
        //创建IntentFilter
        IntentFilter filter = new IntentFilter();
        //指定BroadcastReceiver监听的Action
        filter.addAction("com.jhonlee.music.update");
        //注册BroadcastReceiver
        registerReceiver(receiver, filter);

        seekBarReceiver = new SeekBarReceiver();
        IntentFilter sfilter = new IntentFilter();
        sfilter.addAction("com.jhonlee.music.seekbar_fromserive");
        registerReceiver(seekBarReceiver, sfilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(seekBarReceiver);
        //stopService()
    }

    private class MusicReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //获取Intent中的state消息，update代表播放状态
            flag = intent.getBooleanExtra("flag", false);
            //获取Intent中的current消息，current代表当前正在播放的歌曲
            int newIndex = intent.getIntExtra("index", -1);
            index = newIndex;
            if (newIndex >= 0) {
                Music m = musics.get(newIndex);
                //tvMusicName.setText(m.getSong());

//                seekBar.setMax(m.getDuration());
//                tvTimeT.setText(toTime(m.getDuration()));
            }
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

    private class SeekBarReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int progress = intent.getIntExtra("progress", -1);
            int duration = intent.getIntExtra("duration", -1);
            if (duration != -1) {
                seekBar.setMax(duration);
                tvTimeAll.setText(MusicUtil.formatTime(duration));
            }
            if (progress != -1) {
                seekBar.setProgress(progress);
                tvTimeT.setText(MusicUtil.formatTime(progress));
            }
        }
    }

    private void setSeekBarClick() {

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    Intent intent = new Intent();
                    intent.setAction("com.jhonlee.music.seekbar");
                    intent.putExtra("state", Const.STATE_SEEK);
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
}
