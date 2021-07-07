package com.example.ex5_1_1.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ex5_1_1.ContentActivity;
import com.example.ex5_1_1.R;
import com.example.ex5_1_1.bean.News;
import com.example.ex5_1_1.task.ImageTask;

import java.util.List;

/**
 * Created by Administrator on 2021/4/20 0020.
 */

public class NewsAdapter extends ArrayAdapter {
    int item_layout_id;
    public NewsAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        item_layout_id=resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        final ViewHolder holder;
        if(convertView==null){
            view= LayoutInflater.from(getContext())
                    .inflate(item_layout_id,parent,false);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        News news= (News) getItem(position);
        holder.tv_title.setText(news.getTitle());
//        holder.tv_source.setText(news.getPasstime());
        holder.tv_time.setText(news.getPasstime());
        final String content_url=news.getpath();
        holder.iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ContentActivity.class);
                intent.putExtra("content_url",content_url);
                getContext().startActivity(intent);
            }
        });
        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ContentActivity.class);
                intent.putExtra("content_url",content_url);
                getContext().startActivity(intent);
            }
        });
        holder.tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ContentActivity.class);
                intent.putExtra("content_url",content_url);
                getContext().startActivity(intent);
            }
        });
        //设置图片控件上显示的图片
        String image_url=news.getImage();
                if(TextUtils.isEmpty(image_url)){
                    holder.iv_image.setVisibility(View.GONE);
                }else{
                    new ImageTask(new ImageTask.CallBack() {
                        @Override
                        public void getResult(Bitmap result) {
                            if ((result!=null)){
                                holder.iv_image.setImageBitmap(result);
                            }
                        }
                    }).execute(image_url);
                }
        return view;
    }
    public class ViewHolder{
        TextView tv_title;
//        TextView tv_source;
        TextView tv_time;
//        TextView tv_digest;
        ImageView iv_image;
        public ViewHolder(View view){
            tv_title= (TextView) view.findViewById(R.id.tv_title);
//            tv_source= (TextView) view.findViewById(R.id.tv_source);
            tv_time= (TextView) view.findViewById(R.id.tv_time);
//            tv_digest= (TextView) view.findViewById(R.id.tv_digest);
            iv_image= (ImageView) view.findViewById(R.id.iv_image);

        }
    }
}
