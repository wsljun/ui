package com.cj.reocrd.ui.view;

import android.view.KeyEvent;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseActivity;
import com.cj.reocrd.ui.base.BaseFragment;
import com.cj.reocrd.ui.view.adapter.ViewPagerAdapter;
import com.cj.reocrd.ui.view.fragment.LeadFragment;
import com.cj.reocrd.ui.view.fragment.LoginFragment;
import com.cj.reocrd.ui.view.fragment.RegisterFragment;
import com.cj.reocrd.ui.view.view.MViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class IndexActivity extends BaseActivity {
    @BindView(R.id.vp_index)
    MViewPager vpIndex;
    List<BaseFragment> fragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    public void initView() {
        fragments.add(new LeadFragment());
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
        vpIndex.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments, null));
    }

    public MViewPager getVpLogin() {
        return vpIndex;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            switch (vpIndex.getCurrentItem()) {
                case 0:
                    finish();
                    return true;
                default:
                    vpIndex.setCurrentItem(0);
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
