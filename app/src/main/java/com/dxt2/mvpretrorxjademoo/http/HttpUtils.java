package com.dxt2.mvpretrorxjademoo.http;

import android.util.Log;

import com.dxt2.mvpretrorxjademoo.MainActivity;
import com.dxt2.mvpretrorxjademoo.bean.HotData;
import com.dxt2.mvpretrorxjademoo.callback.OnGetDataListener;
import com.dxt2.mvpretrorxjademoo.http.apiobserverfz.MyObserver;
import com.dxt2.mvpretrorxjademoo.http.apiobserverfz.ObserverOnNextListener;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

public class HttpUtils {

    private static HttpUtils httpUtils = null;
    OnGetDataListener onGetDataListener;

    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    public void setOnGetDataListener(OnGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;
    }

    public void getfirst(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getHotListData()
                .subscribeOn(Schedulers.io())//请求网络在子线程，订阅也在子线程中
                .observeOn(AndroidSchedulers.mainThread()) //如果加上这条，则订阅发生在主线程中
                .subscribe(new Observer<HotData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("====", "onSubscribe: ");
                    }

                    @Override
                    public void onNext(HotData hotData) {
                        if (onGetDataListener != null) {
                            onGetDataListener.onComplete(hotData);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("====", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("====", "onComplete: Over!");
                    }
                });

    }
   /*1.封装retrofit请求过程
    * 2.封装线程管理和订阅
    */

    public void getSecond() {
        Observer<HotData> observer = new Observer<HotData>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HotData hotData) {
                if(onGetDataListener!=null){
                    onGetDataListener.onComplete(hotData);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        ApiFengSubscri.getHData(observer);
    }

    /*1.封装retrofit请求过程
      * 2.封装线程管理和订阅
      * 3.重写Observer对象
      * 暂时有问题
      */
    public void getThree(){
//        ObserverOnNextListener<HotData> listener = new ObserverOnNextListener<HotData>() {
//            @Override
//            public void onNext(HotData hotData) {
//                if(onGetDataListener!=null){
//                    onGetDataListener.onComplete(hotData);
//                }
//            }
//        };
//        ApiFengSubscri.getHData(new MyObserver<HotData>(listener,(MainActivity)this));
    }
}

