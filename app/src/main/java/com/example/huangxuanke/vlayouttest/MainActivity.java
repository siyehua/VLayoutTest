package com.example.huangxuanke.vlayouttest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 10);
        recyclerView.setRecycledViewPool(recycledViewPool);

        DelegateAdapter adapter = new DelegateAdapter(layoutManager, true);


        List<TopBean> tops = new ArrayList<>();
        tops.add(new TopBean("上证指数", "3218.18", "+6.04", "+0.21%"));
        tops.add(new TopBean("上证指数", "3218.18", "+6.04", "+0.21%"));
        tops.add(new TopBean("上证指数", "3218.18", "+6.04", "+0.21%"));
        adapter.addAdapter(new MyAdapter1(this, tops));

        List<String> titles = new ArrayList<>();
        titles.add("热门行业");
        adapter.addAdapter(new MyAdapter2(titles));

        List<HotBean> hots = new ArrayList<>();
        hots.add(new HotBean("煤炭", "+1.24%", "山西黑猫", "9.66 +4.21%"));
        hots.add(new HotBean("煤炭", "+1.24%", "山西黑猫", "9.66 +4.21%"));
        hots.add(new HotBean("煤炭", "+1.24%", "山西黑猫", "9.66 +4.21%"));
        adapter.addAdapter(new MyAdapter3(hots));

        List<String> conceptT = new ArrayList<>();
        conceptT.add("热门概念");
        adapter.addAdapter(new MyAdapter2(conceptT));

        List<HotBean> hotConcepts = new ArrayList<>();
        hotConcepts.add(new HotBean("煤炭", "+1.24%", "山西黑猫", "9.66 +4.21%"));
        hotConcepts.add(new HotBean("煤炭", "+1.24%", "山西黑猫", "9.66 +4.21%"));
        hotConcepts.add(new HotBean("煤炭", "+1.24%", "山西黑猫", "9.66 +4.21%"));
        adapter.addAdapter(new MyAdapter3(hotConcepts));

        List<String> changeT = new ArrayList<>();
        changeT.add("涨幅榜");
        adapter.addAdapter(new MyAdapter2(changeT));

        List<ListBean> listAdd = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listAdd.add(new ListBean("N拉芳", "SH10086", "30.22", "+4.21%"));
        }
        adapter.addAdapter(new MyAdapter4(listAdd));

//        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);


    }

    public static float _750Px2currentPx(Context context, float _750px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _750px * 720 / 750 / 2,
                context.getResources().getDisplayMetrics());
    }
}
