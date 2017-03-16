package com.jhonlee.music;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhonlee.music.pojo.Music;
import com.jhonlee.music.util.MusicUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/13.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {


    private Context mContext;
    private List<Music> mList;
    private MusicListener listener;

    public MusicAdapter(Context mContext, List<Music> mList,MusicListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        this.listener = listener;
    }

    @Override
    public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_music, parent, false);

        return new MusicHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicHolder holder, int position) {
        final Music music = mList.get(position);

        holder.tvName.setText(music.getSong());
        holder.tvAuthor.setText(music.getSinger());
        holder.tvTime.setText(MusicUtil.formatTime(music.getDuration()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.loadMusic(music);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    class MusicHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_time)
        TextView tvTime;

        public MusicHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
