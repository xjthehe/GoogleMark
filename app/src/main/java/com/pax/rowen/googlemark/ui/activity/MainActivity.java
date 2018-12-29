package com.pax.rowen.googlemark.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.pax.rowen.googlemark.R;
import com.pax.rowen.googlemark.ui.Fragment.BaseFragment;
import com.pax.rowen.googlemark.ui.Fragment.FragmentFactory;
import com.pax.rowen.googlemark.ui.view.PagerTab;
import com.pax.rowen.googlemark.utils.UIUtils;

public class MainActivity extends BaseActivity {
    private PagerTab mPagerTab;

    private ViewPager mViewPager;
    private  MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mPagerTab=(PagerTab) findViewById(R.id.pager_tab);
         mViewPager=(ViewPager)findViewById(R.id.viewpager);

         //viewpager填充适配器数据
          myAdapter=new MyAdapter(getSupportFragmentManager());
          mViewPager.setAdapter(myAdapter);

          //指针和viewpager关联
          mPagerTab.setViewPager(mViewPager);


        //onLoad调用触发地方
        mPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment baseFragment=FragmentFactory.creatFragment(position);
                //实际还是loadingpage的loaddate.
                baseFragment.loadDate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //pagerAdapter
    class MyAdapter extends FragmentPagerAdapter{
        private String[] mTabNames=null;

        public MyAdapter(FragmentManager fm) {
             super(fm);
             mTabNames=UIUtils.getStringArray(R.array.tab_names);
        }
        //返回标签题
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

        //當前頁面frgment对象
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            BaseFragment fragment= FragmentFactory.creatFragment(position);
            return fragment;
        }
        //數量
        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }


}
