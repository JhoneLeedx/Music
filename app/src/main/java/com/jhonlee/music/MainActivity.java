package com.jhonlee.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jhonlee.music.pojo.Music;
import com.jhonlee.music.service.MusicService;
import com.jhonlee.music.util.MusicUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MusicListener{

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private List<Music> list ;
    private MusicAdapter adapter;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        serviceIntent = new Intent(MainActivity.this, MusicService.class);
        //启动后台Service
        startService(serviceIntent);

        list = MusicUtil.getData(this);
        adapter = new MusicAdapter(this,list,this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list = MusicUtil.getData(MainActivity.this);
                adapter.notifyDataSetChanged();
                refresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void loadMusic(Music music) {

        Intent intent = new Intent();
        intent.putExtra("music",music);
        intent.setClass(this,PlayActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  stopService(serviceIntent);
    }
}
