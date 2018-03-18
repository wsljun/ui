package com.cj.reocrd.ui.view.fragment;

import android.view.View;
import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/16.
 */

public class AllFragment extends BaseFragment {
    @BindView(R.id.title_left)
    TextView titleLeft;
    @BindView(R.id.title_center)
    TextView titleCenter;
    @BindView(R.id.title_right)
    TextView titleRight;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all;
    }

    @Override
    public void initView() {
        titleCenter.setText(getString(R.string.all));
    }

    @OnClick({R.id.title_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_left:
                getMainActivity().getViewPager().setCurrentItem(0);
                break;
        }
    }
}
