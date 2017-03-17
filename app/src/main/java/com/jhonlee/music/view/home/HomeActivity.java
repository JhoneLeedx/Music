package com.jhonlee.music.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jhonlee.music.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JhoneLee on 2017/3/14.
 */

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ViewpagerAdapter adapter;
    private String[] tableTitle = new String[]{"推荐","新歌","排行榜","日语"};
    private boolean flag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        toolbar.setTitle("音乐");
        toolbar.setLogo(R.drawable.icon);
        setSupportActionBar(toolbar);

        initTabTitle();
    }
    private void initTabTitle() {


        adapter = new ViewpagerAdapter(getSupportFragmentManager(), tableTitle, getList());
        viewpager.setAdapter(adapter);
        //将tabLayout和ViewPager绑定
        tabLayout.setupWithViewPager(viewpager);
    }

    private List<Fragment> getList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new TypeFragment("最新"));
        list.add(new TypeFragment("排行榜"));
        list.add(new TypeFragment("日语"));
        return list;
    }
    @OnClick({R.id.tv_previous, R.id.tv_play_pause, R.id.tv_next,R.id.linearLayout})
    public void Click(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.tv_previous:
                intent.setAction("MusicPrevious");
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
                break;
        }
        sendBroadcast(intent);
    }


}
