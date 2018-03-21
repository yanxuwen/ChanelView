package com.yanxuwen.chanelview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanxuwen.myutils.widget.StatusBar.StatusBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyAdapter mMyAdapter;
    VerticalViewPager mVerticalViewPager;
    List<Bean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBar.setTranslucentStatus(this, false);
        mVerticalViewPager=(VerticalViewPager)findViewById(R.id.verticalviewpager);
        list.add(new Bean("已上市系列", "2018春夏", "http://img5.adesk.com/59c5d143e7bce77b1b837f62?imageMogr2/thumbnail/!1440x2392r/gravity/Center/crop/1440x2392&adult=false.png"));
        list.add(new Bean("发布会", "2018/19秋冬", "http://img5.adesk.com/5800b3eefce12b4b3309f90c?imageMogr2/thumbnail/!1440x2392r/gravity/Center/crop/1440x2392&adult=false.png"));
        list.add(new Bean("已上市系列", "2018春夏预告系列", "http://img5.adesk.com/57d7d601fce12b0f8f1c997e?imageMogr2/thumbnail/!1440x2392r/gravity/Center/crop/1440x2392&adult=false.png"));
        list.add(new Bean("已上市系列", "眼睛系列广告大片", "http://img5.adesk.com/573e92e6fce12b3b4f2163a9?imageMogr2/thumbnail/!1440x2392r/gravity/Center/crop/1440x2392&adult=false.png"));
        list.add(new Bean("HAUTE COUTURE", "2018春夏", "http://img5.adesk.com/5a61a281e7bce736a953c2ca?imageMogr2/thumbnail/!1440x2392r/gravity/Center/crop/1440x2392&adult=false.png"));
        list.add(new Bean("发布会", "METIERE D'ART\nPARIS-HAMBURG\n2017/18", "http://img5.adesk.com/5918fb7ee7bce77b69d4caf7?imageMogr2/thumbnail/!1440x2392r/gravity/Center/crop/1440x2392&adult=false.png"));

        mMyAdapter=new MyAdapter(getSupportFragmentManager(),mVerticalViewPager,list);
        mVerticalViewPager.setAdapter(mMyAdapter);
        mVerticalViewPager.setOffscreenPageLimit(list.size());
        final float mOffset = -this.getResources().getDimension(R.dimen.DIMEN_180DP);

        mVerticalViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                int pageHeight = view.getHeight();
                ImageView iv_picture=view.findViewById(R.id.iv_picture);
                if (position < 1) {
                    view.setTranslationY(mOffset * position);
                    //移动文字
                    if (position >= 0) {
                        TextView tv_title2=(TextView) view.findViewById(R.id.tv_title2);
                        TextView tv_sign=(TextView)view. findViewById(R.id.tv_sign);
                        RelativeLayout layout_live_content=(RelativeLayout) view.findViewById(R.id.layout_live_content);

                        tv_title2.setAlpha((1-position));
                        iv_picture.setScaleX((float) ((1-position)*0.2+1));
                        iv_picture.setScaleY((float) ((1-position)*0.2+1));

                        float live_content_offset;
                        //如果在最后一个，则移动到底部50dp
                        if(tv_sign.getText().toString().trim().equals((list.size() -1))){
                            live_content_offset = pageHeight - MainActivity.this.getResources().getDimension(R.dimen.DIMEN_120DP);
                        } else {
                            live_content_offset = pageHeight -  MainActivity.this.getResources().getDimension(R.dimen.DIMEN_300DP);
                        }
                        layout_live_content.setTranslationY(live_content_offset * (1 - position));
                    }
                } else { // (1,+Infinity]
                    view.setTranslationY(-pageHeight * (position - 1) + (mOffset + (position - 1) * (-mOffset / 2)));
                }
            }
        });

    }
}
