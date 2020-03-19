package com.example.admin.viewstubdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewStub mNetErrorStub, mNoDataStub;
    private View mNetErrorView, mNoDataView;
    TextView goActivity;
    TextView tvNodataView,tvEmptyView;
    private Button mBtShow,mBtHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoDataStub = findViewById(R.id.nodata_layout);
        mNetErrorStub = findViewById(R.id.noerror_layout);
        goActivity = findViewById(R.id.go);

        mBtShow = findViewById(R.id.bt_show);
        mBtHide = findViewById(R.id.bt_hide);

        mBtShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNoData();
            }
        });

        mBtHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNoData();
            }
        });

        new TextCreator(this)
                .addTextOfColor("蓝色", R.color.colorPrimary)
                .addTextOfColor("红色", R.color.colorAccent)
                .addTextOfScale("大字体",2)
                .addText("默认颜色")
                .builder(goActivity);


//        showNoData();
//        showNetError();
    }

    /**
     * 无数据
     */
    public void showNoData(){
        mNetErrorStub.setVisibility(View.GONE);
        if(mNoDataView != null){
            mNoDataView.setVisibility(View.VISIBLE);
            return;
        }
        if(mNoDataStub != null){
            mNoDataView = mNoDataStub.inflate();
            tvNodataView=mNoDataView.findViewById(R.id.tvNodataView);
            tvNodataView.setText("错误测试一下33");
        }
    }

    private void hideNoData(){
        if(mNoDataView != null){
            mNoDataView.setVisibility(View.GONE);
            return;
        }
    }

    /**
     * 通用网络错误界面
     */
    public void showNetError(){
        mNoDataStub.setVisibility(View.GONE);
        if(mNetErrorView != null){
            mNetErrorView.setVisibility(View.VISIBLE);
            return;
        }
        if(mNetErrorStub != null){
            mNetErrorView = mNetErrorStub.inflate();
            tvEmptyView=mNetErrorView.findViewById(R.id.tvEmptyView);
            tvEmptyView.setText("网络测试一下22");
        }
    }
}
