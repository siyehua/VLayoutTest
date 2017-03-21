package com.example.huangxuanke.vlayouttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

import java.util.List;

/**
 * Created by huangxuanke on 2017/3/21.
 */

public class MyAdapter4 extends DelegateAdapter.Adapter<MyAdapter4.ViewHolder> {
    private List<ListBean> list;

    public MyAdapter4(List<ListBean> list) {
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item4, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListBean bean = list.get(position);
        holder.title.setText(bean.name);
        holder.code.setText(bean.code);
        holder.price.setText(bean.price);
        holder.percent.setText(bean.percent);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 4;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, code, price, percent;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            code = (TextView) itemView.findViewById(R.id.tv_code);
            price = (TextView) itemView.findViewById(R.id.tv_price);
            percent = (TextView) itemView.findViewById(R.id.tv_percent);
        }
    }
}
