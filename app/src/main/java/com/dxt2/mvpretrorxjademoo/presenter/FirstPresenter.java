package com.dxt2.mvpretrorxjademoo.presenter;

import com.dxt2.mvpretrorxjademoo.bean.HotData;
import com.dxt2.mvpretrorxjademoo.callback.OnGetDataListener;
import com.dxt2.mvpretrorxjademoo.model.FirstModelImpl;
import com.dxt2.mvpretrorxjademoo.model.IFirstModel;
import com.dxt2.mvpretrorxjademoo.view.IFirstView;

import java.lang.ref.WeakReference;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

public class FirstPresenter<T extends IFirstView> implements OnGetDataListener{

    protected WeakReference<T> mViewRef;
    IFirstModel iFirstModel = new FirstModelImpl(this);
    IFirstView iFirstView;

//    public FirstPresenter(IFirstView iFirstView) {
//        this.iFirstView = iFirstView;
//    }

    public FirstPresenter(){
    }

    //去modul中取数据
    public void getListData(){
        iFirstModel.loadData();
    }

    @Override
    public void onComplete(HotData hotData) {
        iFirstView.setData(hotData);

    }
    public void attachView(T view){
        mViewRef = new  WeakReference<T>(view);
    }
    public void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
        }
    }
}
