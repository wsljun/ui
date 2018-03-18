package com.cj.reocrd.ui.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseFragment;
import com.cj.reocrd.ui.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/16.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.title_left)
    TextView titleLeft;
    @BindView(R.id.title_center)
    TextView titleCenter;
    @BindView(R.id.title_right)
    TextView titleRight;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        titleLeft.setVisibility(View.GONE);
        titleCenter.setText(getString(R.string.home));
        titleRight.setBackgroundResource(R.mipmap.gouwuche);
        titleRight.setVisibility(View.VISIBLE);
    }
    @OnClick({R.id.title_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_right:
                getMainActivity().getViewPager().setCurrentItem(3);
                break;
        }
    }
}
