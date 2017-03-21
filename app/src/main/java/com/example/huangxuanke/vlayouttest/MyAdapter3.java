package com.example.huangxuanke.vlayouttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import java.util.List;

/**
 * Created by huangxuanke on 2017/3/21.
 */

public class MyAdapter3 extends DelegateAdapter.Adapter<MyAdapter3.ViewHolder> {
    private List<HotBean> list;

    public MyAdapter3(List<HotBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new GridLayoutHelper(3, 3);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item3, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HotBean bean = list.get(position);
        holder.title1.setText(bean.title1);
        holder.percent.setText(bean.percent);
        holder.title2.setText(bean.title2);
        holder.info.setText(bean.info);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 3;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title1, percent, title2, info;

        public ViewHolder(View itemView) {
            super(itemView);
            title1 = (TextView) itemView.findViewById(R.id.tv_title1);
            percent = (TextView) itemView.findViewById(R.id.tv_change_percent);
            title2 = (TextView) itemView.findViewById(R.id.tv_title2);
            info = (TextView) itemView.findViewById(R.id.tv_info);
        }
    }
}
