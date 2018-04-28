package com.dxt2.mvpretrorxjademoo.http.apiobserverfz;


import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
//重写Observer
public class MyObserver<T>  implements Observer<T> {
    private ObserverOnNextListener listener;
    private Context context;

    public MyObserver(ObserverOnNextListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {
        listener.onNext(value);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
