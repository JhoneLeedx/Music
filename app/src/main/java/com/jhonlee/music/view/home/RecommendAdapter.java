package com.jhonlee.music.view.home;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.music.R;
import com.jhonlee.music.listener.MenuClickListener;
import com.jhonlee.music.pojo.PlayList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by JhoneLee on 2017/3/15.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<PlayList> mList;
    private Context mContext;

    private MenuClickListener listener;
    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;

    public RecommendAdapter(List<PlayList> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public RecommendAdapter(List<PlayList> mList, Context mContext, MenuClickListener listener) {
        this.mList = mList;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == TYPE_FOOTER) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_foot_view, parent, false);
            return new FootHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_recommend, parent, false);
            return new RecommendHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof RecommendHolder) {
            final PlayList playList = mList.get(position);
            Glide.with(mContext).load(playList.getCoverImgUrl()).into(((RecommendHolder) holder).ivTitle);
            ((RecommendHolder) holder).tvCount.setText(playList.getPlayCount() + "");
            ((RecommendHolder) holder).tvDesc.setText(playList.getName());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.showDetail(playList.getCoverImgUrl(), playList.getId(), playList.getName());
                }
            });
        }
    }
    //变换底部占满 footview
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager g = (GridLayoutManager) manager;
            g.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return TYPE_FOOTER == getItemViewType(position) ? g.getSpanCount() : 1;
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == mList.size()) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    class RecommendHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_title)
        ImageView ivTitle;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.tv_desc)
        TextView tvDesc;

        public RecommendHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class FootHolder extends RecyclerView.ViewHolder {

        public FootHolder(View itemView) {
            super(itemView);
        }
    }
}
