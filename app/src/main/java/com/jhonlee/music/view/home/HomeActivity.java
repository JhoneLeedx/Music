package com.jhonlee.music.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jhonlee.music.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}
