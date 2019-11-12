package com.example.shixun;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsBean> {
    private int resourceId;

    public NewsAdapter(Context context, int resource, List<NewsBean> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        NewsBean newsBean = getItem(position);

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.newsTitle=(TextView)view.findViewById(R.id.title);
            viewHolder.newsdate=(TextView)view.findViewById(R.id.date);
            viewHolder.newsimage=(ImageView)view.findViewById(R.id.newsimage);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.newsTitle.setText(newsBean.getTitle());
        viewHolder.newsdate.setText(newsBean.getDate());
        ImageLoader.getInstance().displayImage(newsBean.getThumbnail_pic_s(),viewHolder.newsimage);
        return view;
    }
    class ViewHolder{
        TextView newsTitle;
        TextView newsdate;
        ImageView newsimage;
    }
}