package com.yanxuwen.chanelview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 */
public class PlaceholderFragment extends Fragment {
    public interface OnLiveClickListenner {
        public void onLiveClick(int position);
    }
    static OnLiveClickListenner mOnLiveClickListenner;
    public void setOnLiveClickListenner(OnLiveClickListenner l){
        mOnLiveClickListenner=l;
    }
    Bean databean;
    int position;
    private static final String ARG_SECTION_DATA = "section_data";
    private static final String ARG_SECTION_NUMBER = "section_number";
    public PlaceholderFragment newInstance(Bean databean, int position ) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SECTION_DATA,databean);
        args.putSerializable(ARG_SECTION_NUMBER,position);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databean = (Bean) getArguments().getSerializable(ARG_SECTION_DATA);
        position = getArguments().getInt(ARG_SECTION_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        TextView tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        tv_title.setText(databean.getTitle());
        TextView tv_title2 = (TextView) rootView.findViewById(R.id.tv_title2);
        TextView tv_sign = (TextView) rootView.findViewById(R.id.tv_sign);
        tv_sign.setText(position+"");
        tv_title2.setVisibility(View.VISIBLE);
        tv_title2.setText(databean.getTitle2());
        ImageView iv_picture = (ImageView) rootView.findViewById(R.id.iv_picture);
        Glide.with(getContext())
                .load(databean.getUrl())
                .override(ScreenUtils.getScreenWidth(getContext())/2,ScreenUtils.getScreenHeight(getContext())/2)
                .centerCrop()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher).into(iv_picture);

        iv_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnLiveClickListenner!=null)mOnLiveClickListenner.onLiveClick(position);
            }
        });
        return rootView;
    }
}

