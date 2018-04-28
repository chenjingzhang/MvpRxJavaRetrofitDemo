package com.dxt2.mvpretrorxjademoo.http;

import com.dxt2.mvpretrorxjademoo.bean.HotData;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

public class ApiFengSubscri {
    /*封装线程管理和订阅的过程
    * */
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getHData(Observer<HotData> observer) {
        ApiSubscribe(ApiFengRetro.getApiService().getHotListData(), observer);
    }


}
