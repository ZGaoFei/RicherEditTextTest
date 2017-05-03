package com.example.zgfei.avloading;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zgfei.richeredittexttest.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

/**
 * Created by zgfei on 2017/5/2.
 */

public class AvLoadingAdapter extends RecyclerView.Adapter<AvLoadingAdapter.ViewHolder> {
    private Context context;
    private List<String> list;

    public AvLoadingAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_av_loading, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.view.setIndicator(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public AVLoadingIndicatorView view;

        public ViewHolder(View itemView) {
            super(itemView);

            view = (AVLoadingIndicatorView) itemView.findViewById(R.id.av_loading);
        }
    }
}
