package com.cj.reocrd.ui.view.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseFragment;
import com.cj.reocrd.ui.utils.ToastUtil;
import com.cj.reocrd.ui.view.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/15.
 */

public class LoginFragment extends BaseFragment {
    @BindView(R.id.title_left)
    TextView titleLeft;
    @BindView(R.id.title_center)
    TextView titleCenter;
    @BindView(R.id.title_right)
    TextView titleRight;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView() {
        titleCenter.setText(R.string.login_title);
    }


    @OnClick({R.id.login_lose, R.id.login,R.id.title_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_lose:
                ToastUtil.showToastS(mActivity,"login_lose");
                break;
            case R.id.login:
                Intent intent = new Intent(mActivity, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.title_left:
                getIndexActivity().getVpLogin().setCurrentItem(0);
                break;
        }
    }
}
