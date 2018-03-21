package com.yanxuwen.chanelview;

import java.io.Serializable;

/**
 * Created by yanxuwen on 2018/3/21.
 */

public class Bean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String title2;
    private String url;

    public Bean(String title, String title2, String url) {
        this.title = title;
        this.title2 = title2;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }
}
