package com.jackie.shoppingmall1.home.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.jackie.shoppingmall1.base.BaseFragment;

/**
 * Created by jackie on 2017/2/6 23:57.
 * QQ : 971060378
 * Used as : xxx
 */
public class HomeFragment extends BaseFragment {

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
        textView.setText("主页内容");
    }
}
