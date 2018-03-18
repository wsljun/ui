package com.cj.reocrd.ui.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/15.
 */

public class UpdatePwdFragment extends BaseFragment {
    @BindView(R.id.title_left)
    TextView titleLeft;
    @BindView(R.id.title_center)
    TextView titleCenter;
    @BindView(R.id.title_right)
    TextView titleRight;
    @BindView(R.id.update_pwd1)
    EditText updatePwd1;
    @BindView(R.id.update_pwd2)
    EditText updatePwd2;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_update_pwd;
    }

    @Override
    public void initView() {
        titleCenter.setText(getString(R.string.my_update_pwd));
    }


    @OnClick(R.id.update_login)
    public void onViewClicked() {
        getMyActivity().getViewPager().setCurrentItem(0);
    }
}
