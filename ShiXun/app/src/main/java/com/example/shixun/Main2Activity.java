package com.example.shixun;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//MainActivity所在的线程位主UI线程
public class Main2Activity extends AppCompatActivity {


    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;
    private TextView mTv7;

    private TextView mWebData;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {

        FragmentManager mManager = getSupportFragmentManager();
        FragmentTransaction mTransaction;

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.tv1:
                    Fragment1 fragment1 = new Fragment1();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment1);
                    mTransaction.commit();
                    break;
                case R.id.tv2:
                    //写碎片的加载逻辑
                    Fragment2 fragment2 = new Fragment2();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment2);
                    mTransaction.commit();
                    break;
                case R.id.tv3:
                    Fragment3 fragment3 = new Fragment3();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment3);
                    mTransaction.commit();
                    break;
                case R.id.tv4:
                    Fragment4 fragment4 = new Fragment4();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment4);
                    mTransaction.commit();
                    break;
                case R.id.tv5:
                    Fragment5 fragment5 = new Fragment5();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment5);
                    mTransaction.commit();
                    break;
                case R.id.tv6:
                    Fragment6 fragment6 = new Fragment6();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment6);
                    mTransaction.commit();
                    break;
                case R.id.tv7:
                    Fragment7 fragment7 = new Fragment7();
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.framelayout, fragment7);
                    mTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TabHost 用于管理选项卡的一个控件
        //TabWidget 选项卡
        setContentView(R.layout.tabhost);

        initTab();
        initTV();

    }

    private void initTV() {
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv3 = (TextView) findViewById(R.id.tv3);
        mTv4 = (TextView) findViewById(R.id.tv4);
        mTv5 = (TextView) findViewById(R.id.tv5);
        mTv6 = (TextView) findViewById(R.id.tv6);
        mTv7 = (TextView) findViewById(R.id.tv7);

        mTv1.setOnClickListener(mOnClickListener);
        mTv2.setOnClickListener(mOnClickListener);
        mTv3.setOnClickListener(mOnClickListener);
        mTv4.setOnClickListener(mOnClickListener);
        mTv5.setOnClickListener(mOnClickListener);
        mTv6.setOnClickListener(mOnClickListener);
        mTv7.setOnClickListener(mOnClickListener);
    }

    private void initTab() {

        final TabHost tabHost = findViewById(R.id.main_tabhost);
        tabHost.setup();

        //create tabspec 用来给选项卡指定具体的内容
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tab1").setIndicator("模块1").setContent(R.id.tab01);
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tab2").setIndicator("模块2").setContent(R.id.tab02);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tab3").setIndicator("模块3").setContent(R.id.tab03);

        //add tabspec
        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);

        //setonchangedlistener
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {

                if (tabId.equals("tab1"))
                {
                    //TODO
//                    Toast.makeText(Main2Activity.this, "tab1", Toast.LENGTH_SHORT).show();
                }

                if (tabId.equals("tab2"))
                {
                    //TODO
                    Intent intent=new Intent(Main2Activity.this,NewsList.class);
                    startActivity(intent);
//                    Toast.makeText(Main2Activity.this, "tab2", Toast.LENGTH_SHORT).show();
                }
                if (tabId.equals("tab3"))
                {
                    //TODO
//                    Toast.makeText(Main2Activity.this, "tab3", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}