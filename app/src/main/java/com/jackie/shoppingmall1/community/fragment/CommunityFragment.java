package com.jackie.shoppingmall1.community.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.jackie.shoppingmall1.base.BaseFragment;

/**
 * Created by jackie on 2017/2/7 0:11.
 * QQ : 971060378
 * Used as : xxx
 */
public class CommunityFragment extends BaseFragment {

    private TextView textView;

    @Override
    protected View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(18);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("发现内容");
    }
}

