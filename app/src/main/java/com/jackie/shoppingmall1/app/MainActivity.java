package com.jackie.shoppingmall1.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.jackie.shoppingmall1.R;
import com.jackie.shoppingmall1.base.BaseFragment;
import com.jackie.shoppingmall1.community.fragment.CommunityFragment;
import com.jackie.shoppingmall1.home.fragment.HomeFragment;
import com.jackie.shoppingmall1.shoppingcart.fragment.ShoppingCartFragment;
import com.jackie.shoppingmall1.type.fragment.TypeFragment;
import com.jackie.shoppingmall1.user.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    /**
     * 装Fragment的集合
     */
    private List<BaseFragment> baseFragments;
    /**
     * RadioGroup的选中位置
     */
    private int position;
    /**
     * 上次的Fragment
     */
    private Fragment fromFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化视图
        initView();
        //初始化Fragment
        initFragment();
        //初始化RadioGroup的监听
        initListener();
    }

    private void initListener() {
        rg_main.setOnCheckedChangeListener(new MyCheckedChangeListener());
        //设置默认选中
        rg_main.check(R.id.rb_home);
    }

    private void initFragment() {
        baseFragments = new ArrayList<>();
        baseFragments.add(new HomeFragment());
        baseFragments.add(new TypeFragment());
        baseFragments.add(new CommunityFragment());
        baseFragments.add(new ShoppingCartFragment());
        baseFragments.add(new UserFragment());
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
    }

    class MyCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_home:
                    position = 0;
                    break;
                case R.id.rb_type:
                    position = 1;
                    break;
                case R.id.rb_community:
                    position = 2;
                    break;
                case R.id.rb_cart:
                    position = 3;
                    break;
                case R.id.rb_user:
                    position = 4;
                    break;
                default:
                    position = 0;
                    break;
            }
            //根据选中的位置得到相应的Fragment
            BaseFragment toFragment = getFragment();
            //切换Fragment
            switchFragment(fromFragment, toFragment);
        }
    }

    /**
     * @param fromFragment 刚显示的Fragment,马上就要被隐藏了
     * @param toFragment   马上要切换到的Fragment，一会要显示
     */
    private void switchFragment(Fragment fromFragment, BaseFragment toFragment) {
        if (fromFragment != toFragment) {
            MainActivity.this.fromFragment = toFragment;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!toFragment.isAdded()) {
                //to没有被添加
                //from隐藏
                if (fromFragment != null) {
                    ft.hide(fromFragment);
                }
                //添加to
                ft.add(R.id.frameLayout, toFragment).commit();
            } else {
                //to已经被添加
                // from隐藏
                if (fromFragment != null) {
                    ft.hide(fromFragment);
                }
                //显示to
                ft.show(toFragment).commit();
            }
        }
    }

    /**
     * 根据选中的位置得到相应的Fragment
     *
     * @return
     */
    private BaseFragment getFragment() {
        if (baseFragments != null && baseFragments.size() > 0) {
            return baseFragments.get(position);
        }
        return null;
    }
}
