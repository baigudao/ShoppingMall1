package com.jackie.shoppingmall1.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackie.shoppingmall1.R;
import com.jackie.shoppingmall1.base.BaseFragment;

/**
 * Created by jackie on 2017/2/6 23:57.
 * QQ : 971060378
 * Used as : 主页面的Fragment
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView rvHome;
    private ImageView ib_top;
//    private HomeRecyclerAdapter adapter;
    private TextView tv_search_home;
    private TextView tv_message_home;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        tv_search_home = (TextView) view.findViewById(R.id.tv_search_home);
        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        return view;
    }

    /**
     * 绑定数据
     */
    @Override
    protected void initData() {
        super.initData();
    }
}
