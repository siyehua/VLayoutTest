package com.example.huangxuanke.vlayouttest;

import android.content.Context;
import android.graphics.Color;
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

public class MyAdapter1 extends DelegateAdapter.Adapter<MyAdapter1.ViewHolder> {
    private List<TopBean> list;
    GridLayoutHelper gridLayoutHelper;

    public MyAdapter1(Context context, List<TopBean> list) {
        this.list = list;
        gridLayoutHelper = new GridLayoutHelper(3, 3);
        gridLayoutHelper.setBgColor(Color.parseColor("#EAEEF2"));

        int lr = (int) MainActivity._750Px2currentPx(context, 6);
        int tb = (int) MainActivity._750Px2currentPx(context, 20);
        gridLayoutHelper.setPadding(lr, tb, lr, 0);
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item1, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TopBean bean = list.get(position);
        holder.title.setText(bean.title);
        holder.current.setText(bean.price);
        holder.change.setText(bean.change);
        holder.percent.setText(bean.percent);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, current, change, percent;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            current = (TextView) itemView.findViewById(R.id.tv_current_price);
            change = (TextView) itemView.findViewById(R.id.tv_change_price);
            percent = (TextView) itemView.findViewById(R.id.tv_change_percent);

        }
    }
}
