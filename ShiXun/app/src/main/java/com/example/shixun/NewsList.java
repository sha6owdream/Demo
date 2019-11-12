package com.example.shixun;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsList extends AppCompatActivity {
    public List <NewsBean> newsBeanList = new ArrayList <>();
    ListView mlistView;
    SwipeRefreshLayout refresh=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newslist);
        ImageLoaderConfiguration build=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(build);

        refresh = (SwipeRefreshLayout) findViewById(R.id.id_swipe_ly);//实例化
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
                refresh.setRefreshing(false);
            }
        });
        loadData();
    }
    private void loadData () {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final URL url = new URL("http://v.juhe.cn/toutiao/index?type=top&key=b0fae36e5d73e3d17e35d6d9f7b337b8");
//                    final URL url = new URL("http://v.juhe.cn/toutiao/index?type=2&key=57eee480312cb6c613c50237e7ba325b");
                    // 通过url对象获取一个网络连接对象
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    // 设置请求方式
                    conn.setRequestMethod("GET");
                    // 设置读取数据的时间
                    conn.setReadTimeout(4000);

                    // 设置联网时间
                    conn.setConnectTimeout(5000);

                    conn.connect();
                    StringBuffer sBuffer = new StringBuffer();
                    String str = null;

                    // 从网络上获取到的数据是一个json字符串,
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    // 读取bRead指向的数据
                    while ((str = bReader.readLine()) != null) {
                        sBuffer.append(str);
                    }

                    // Json解析
                    JSONObject object = new JSONObject(sBuffer.toString());
                    object = object.getJSONObject("result");
                    JSONArray jsonArray = object.getJSONArray("data");

                    newsBeanList = new ArrayList<NewsBean>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        object = (JSONObject) jsonArray.get(i);
                        NewsBean bean = new NewsBean();
                        bean.setTitle(object.getString("title"));
                        bean.setDate(object.getString("date"));
                        bean.setThumbnail_pic_s(object.getString("thumbnail_pic_s"));
                        bean.setUrl(object.getString("url"));
                        newsBeanList.add(bean);
                    }
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            //更新UI
                            NewsAdapter adapter = new NewsAdapter(NewsList.this, R.layout.newscontent, newsBeanList);
                            mlistView = (ListView) findViewById(R.id.listview);
                            mlistView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                            mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                                    NewsBean newsBean=newsBeanList.get(position);
                                    String url=newsBean.getUrl();
                                    Uri uri = Uri.parse(url);
                                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

