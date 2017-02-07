package com.jackie.shoppingmall1.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.shoppingmall1.R;
import com.jackie.shoppingmall1.base.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

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
        getDataFromNet();
    }

    /**
     * 网络请求
     */
    private void getDataFromNet() {
        String url = "http://172.17.53.1:8080/atguigu/json/HOME_URL.json";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }

    class MyStringCallback extends StringCallback {
        /**
         * 联网失败回调的方法
         *
         * @param call
         * @param e
         * @param id
         */
        @Override
        public void onError(Call call, Exception e, int id) {
            Toast.makeText(mContext, "联网失败！", Toast.LENGTH_SHORT).show();
        }

        /**
         * 联网成功回调的方法
         *
         * @param response
         * @param id
         */
        @Override
        public void onResponse(String response, int id) {
            Toast.makeText(mContext, response, Toast.LENGTH_SHORT).show();
        }
    }
}
