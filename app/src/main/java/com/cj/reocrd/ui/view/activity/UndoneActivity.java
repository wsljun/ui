package com.cj.reocrd.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseActivity;
import com.cj.reocrd.ui.utils.ToastUtil;
import com.cj.reocrd.ui.view.adapter.AddressAdapter;
import com.cj.reocrd.ui.view.adapter.UndoneAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/17.
 */

public class UndoneActivity extends BaseActivity implements UndoneAdapter.OnItemListener {
    @BindView(R.id.title_left)
    TextView titleLeft;
    @BindView(R.id.title_center)
    TextView titleCenter;
    @BindView(R.id.title_right)
    TextView titleRight;
    @BindView(R.id.undone_recycler)
    RecyclerView undoneRecycler;
    UndoneAdapter undoneAdapter;
    List<String> mDatas;
    int type;
    public static final int PAY = 1;//待付款
    public static final int SEND = 2;//待发货
    public static final int CONFIM = 3;//待确认
    public static final int EVALUATE = 4;//待评价

    public static void actionActivity(Context context, int type) {
        Intent sIntent = new Intent(context, UndoneActivity.class);
        sIntent.putExtra("type", type);
        context.startActivity(sIntent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_undone;
    }

    @Override
    public void initData() {
        super.initData();
        //这四个页面都差不多，就放到一块了，type标示，加载不同布局
        type = getIntent().getIntExtra("type", 1);
        mDatas = new ArrayList<>();
        mDatas.add("1");
        mDatas.add("2");
        mDatas.add("3");
    }

    @Override
    public void initView() {
        switch (type){
            case 1:
                titleCenter.setText(getString(R.string.mine_daifukuan));
                break;
            case 2:
                titleCenter.setText(getString(R.string.mine_daifahuo));
                break;
            case 3:
                titleCenter.setText(getString(R.string.mine_daiqueren));
                break;
            case 4:
                titleCenter.setText(getString(R.string.mine_daipingjia));
                break;
        }
        //type传给adapter，调整不同布局
        undoneAdapter = new UndoneAdapter(this, mDatas,type);
        undoneAdapter.setOnItemListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        undoneRecycler.setLayoutManager(layoutManager);
        undoneRecycler.setAdapter(undoneAdapter);
        undoneRecycler.setItemAnimator(new DefaultItemAnimator());
    }


    @OnClick({R.id.title_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_left:
                finish();
                break;
        }
    }

    @Override
    public void takeClick(int position) {
        ToastUtil.showToastS(this, "takeClick" + position);
    }

    @Override
    public void refundClick(int position) {
        ToastUtil.showToastS(this, "refundClick" + position);
    }
}
