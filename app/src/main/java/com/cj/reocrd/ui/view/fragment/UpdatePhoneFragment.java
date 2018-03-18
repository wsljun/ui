package com.cj.reocrd.ui.view.fragment;

import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/17.
 */

public class UpdatePhoneFragment extends BaseFragment {
    @BindView(R.id.title_left)
    TextView titleLeft;
    @BindView(R.id.title_center)
    TextView titleCenter;
    @BindView(R.id.title_right)
    TextView titleRight;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_update_phone;
    }

    @Override
    public void initView() {
        titleCenter.setText(getString(R.string.my_update_phone));
    }

}
