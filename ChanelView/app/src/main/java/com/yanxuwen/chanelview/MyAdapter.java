package com.yanxuwen.chanelview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yanxuwen on 2018/3/21.
 */

public class MyAdapter extends FragmentPagerAdapter implements PlaceholderFragment.OnLiveClickListenner {
    List<Bean> list;
    PlaceholderFragment mPlaceholderFragment;
    VerticalViewPager mVerticalViewPager;
    public MyAdapter(FragmentManager fm,VerticalViewPager mVerticalViewPager,List<Bean> list) {
        super(fm);
        this.list=list;
        this.mVerticalViewPager=mVerticalViewPager;
        mPlaceholderFragment=new PlaceholderFragment();
        mPlaceholderFragment.setOnLiveClickListenner(this);

    }

    @Override
    public Fragment getItem(int position) {
        return mPlaceholderFragment.newInstance(list.get(position), position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void onLiveClick(int position) {
        //执行点击事件
        Bean databean=list.get(position);
        if (databean == null ) return;
        //如果点击的不是当前项目，则滑动到下一项
        if(position!=mVerticalViewPager.getCurrentItem()){
            mVerticalViewPager.setCurrentItemInternal( mVerticalViewPager.getCurrentItem()+1,true,false,1000);
        }
    }
}
