package com.dxt2.mvpretrorxjademoo.model;

import com.dxt2.mvpretrorxjademoo.callback.OnGetDataListener;
import com.dxt2.mvpretrorxjademoo.http.HttpUtils;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

public class FirstModelImpl implements IFirstModel {
    OnGetDataListener listener;

    public FirstModelImpl(OnGetDataListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadData() {
        //网络请求
        HttpUtils httpUtils = new HttpUtils();
//        httpUtils.getfirst("http://interfaces.ziroom.com/");
//        httpUtils.getSecond();
        httpUtils.getThree();
        httpUtils.setOnGetDataListener(listener);
    }
}




























