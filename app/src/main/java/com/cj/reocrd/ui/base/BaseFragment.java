package com.cj.reocrd.ui.base;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cj.reocrd.ui.R;
import com.cj.reocrd.ui.view.IndexActivity;
import com.cj.reocrd.ui.view.activity.MainActivity;
import com.cj.reocrd.ui.view.activity.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/15.
 */

public abstract class BaseFragment extends Fragment {
    public BaseActivity mActivity;
    public Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
        if (savedInstanceState != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (ft != null && isAdded()) {
                ft.remove(this);
                ft.commit();
            }
            if (getParentFragment() != null) {
                FragmentTransaction pft = getParentFragment().getChildFragmentManager().beginTransaction();
                if (pft != null && isAdded()) {
                    pft.remove(this);
                    pft.commit();
                }
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    private final void init() {
        initData();
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public void initData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public IndexActivity getIndexActivity() {
        if (mActivity != null && !mActivity.isFinishing() && mActivity instanceof IndexActivity) {
            return (IndexActivity) mActivity;
        }
        return null;
    }

    public MainActivity getMainActivity() {
        if (mActivity != null && !mActivity.isFinishing() && mActivity instanceof MainActivity) {
            return (MainActivity) mActivity;
        }
        return null;
    }

    public MyActivity getMyActivity() {
        if (mActivity != null && !mActivity.isFinishing() && mActivity instanceof MyActivity) {
            return (MyActivity) mActivity;
        }
        return null;
    }
}
