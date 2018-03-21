## ChanelView
废话不多说，请看效果图。

|              Chanel App效果图               |                  我实现的效果                  |
| :--------------------------------------: | :--------------------------------------: |
| ![Chanel App Gif](https://github.com/yanxuwen/ChanelView/blob/master/ChanelGIF.gif) | ![ Chanel View ](https://github.com/yanxuwen/ChanelView/blob/master/MyChanel.gif) |

有兴趣的可以自己去下载一下 Chanel 的 App 来把玩一下，里面有一些效果还是不错的；不过这个App 启动的时候很慢不知道是不是网络的问题。最开始我看到这个效果是一脸问号。效果是从这个 App 里面反编译出来的代码找出来的。

## 实现原理介绍
采用的是 竖行的ViewPage 来实现的，相信大家都知道怎么弄，然后就是在ViewPage的transformPage方法里面,里面要怎么样的效果都可以自行修改。
~~~
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
~~~
### APK 地址：https://www.pgyer.com/xsIo
### 喜欢就在github star下,非常感谢o(∩_∩)o~~~
