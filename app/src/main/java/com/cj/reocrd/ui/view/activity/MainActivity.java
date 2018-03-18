package com.cj.reocrd.ui.view.activity;

import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.base.BaseActivity;
import com.cj.reocrd.ui.base.BaseFragment;
import com.cj.reocrd.ui.view.adapter.ViewPagerAdapter;
import com.cj.reocrd.ui.view.fragment.AllFragment;
import com.cj.reocrd.ui.view.fragment.CarFragment;
import com.cj.reocrd.ui.view.fragment.FriendsFragment;
import com.cj.reocrd.ui.view.fragment.HomeFragment;
import com.cj.reocrd.ui.view.fragment.MineFragment;
import com.cj.reocrd.ui.view.view.MViewPager;
import com.jpeng.jptabbar.JPTabBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/16.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_viewPager)
    MViewPager viewPager;
    @BindView(R.id.main_tabLayout)
    JPTabBar tabLayout;
    List<BaseFragment> fragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public MViewPager getViewPager() {
        return viewPager;
    }

    @Override
    public void initView() {

        fragments.add(new HomeFragment());
        fragments.add(new AllFragment());
        fragments.add(new FriendsFragment());
        fragments.add(new CarFragment());
        fragments.add(new MineFragment());
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments, null));

        tabLayout.setTitles(getString(R.string.home), getString(R.string.all), getString(R.string.friends), getString(R.string.car), getString(R.string.mine))
                .setNormalIcons(R.mipmap.shouye2, R.mipmap.quanbushangpin, R.mipmap.quanzi, R.mipmap.guwuche, R.mipmap.wode)
                .setSelectedIcons(R.mipmap.shouye, R.mipmap.quanbushangpinxuanzhjong, R.mipmap.quanzixuanzhong, R.mipmap.goouwucheshixin, R.mipmap.wodeshixin)
                .generate();
        tabLayout.setIconSize(19);
        tabLayout.setContainer(viewPager);
    }
}
