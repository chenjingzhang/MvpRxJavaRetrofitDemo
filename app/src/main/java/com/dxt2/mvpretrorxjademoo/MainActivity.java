package com.dxt2.mvpretrorxjademoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.dxt2.mvpretrorxjademoo.adapter.MyAdapter;
import com.dxt2.mvpretrorxjademoo.bean.HotData;
import com.dxt2.mvpretrorxjademoo.presenter.FirstPresenter;
import com.dxt2.mvpretrorxjademoo.presenter.SecondPresenter;
import com.dxt2.mvpretrorxjademoo.view.IFirstView;

public class MainActivity extends AppCompatActivity implements IFirstView {
    ListView listView;
    SecondPresenter secondPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        //1
//        new FirstPresenter(this).getListData();
        //2
//        firstPresenter = new FirstPresenter<>();
//        firstPresenter.attachView(this);
//        firstPresenter.getListData();

      //3只封装了BasePresenter
       secondPresenter = new SecondPresenter();
       secondPresenter.attachView(this);
       secondPresenter.getListData();

    }

    @Override
    public void setData(HotData hotData) {
        listView.setAdapter(new MyAdapter(hotData.getData(), this));
    }

    @Override
    public void setFailMessage() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        secondPresenter.detachView();
    }
}
