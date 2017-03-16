package com.jhonlee.music.view.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jhonlee.music.R;
import com.jhonlee.music.listener.MusicItemListener;
import com.jhonlee.music.pojo.SongMenuDetail;
import com.jhonlee.music.util.MusicUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {


    private List<SongMenuDetail.TracksBean> mList;
    private Context mContext;
    private MusicItemListener listener;

    public DetailAdapter(List<SongMenuDetail.TracksBean> mList, Context mContext, MusicItemListener listener) {
        this.mList = mList;
        this.mContext = mContext;
        this.listener = listener;
    }

    public DetailAdapter(List<SongMenuDetail.TracksBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public DetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_playlist_detail, parent, false);
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailHolder holder, int position) {
        final SongMenuDetail.TracksBean track = mList.get(position);
        holder.tvName.setText(track.getName());
        holder.tvAuthor.setText(track.getArtists().get(0).getName());
        holder.tvAllTime.setText(MusicUtil.formatTime(track.getDuration())+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.playItemMusic(track.getMp3Url());
            }
        });
        holder.ivDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"图片点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class DetailHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_music_name)
        TextView tvName;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_time_all)
        TextView tvAllTime;
        @BindView(R.id.iv_detail)
        ImageView ivDetail;
        public DetailHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
