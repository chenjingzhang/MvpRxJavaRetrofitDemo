package com.dxt2.mvpretrorxjademoo.presenter;

import com.dxt2.mvpretrorxjademoo.bean.HotData;
import com.dxt2.mvpretrorxjademoo.callback.OnGetDataListener;
import com.dxt2.mvpretrorxjademoo.model.FirstModelImpl;
import com.dxt2.mvpretrorxjademoo.model.IFirstModel;
import com.dxt2.mvpretrorxjademoo.view.IFirstView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/4/28 0028.
 */

public class SecondPresenter extends BasePresenter<IFirstView> implements OnGetDataListener {


    IFirstModel iFirstModel = new FirstModelImpl(this);


//    public FirstPresenter(IFirstView iFirstView) {
//        this.iFirstView = iFirstView;
//    }

    public SecondPresenter() {
    }

    //去modul中取数据
    public void getListData() {
        iFirstModel.loadData();
    }

    @Override
    public void onComplete(HotData hotData) {
        IFirstView iFirstView = getView();
        if (iFirstView != null) {
            iFirstView.setData(hotData);

        }

    }


}
