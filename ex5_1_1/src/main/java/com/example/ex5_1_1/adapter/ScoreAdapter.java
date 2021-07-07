package com.example.ex5_1_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ex5_1_1.R;
import com.example.ex5_1_1.Score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by One L on 2019/9/21.ion
 *
 * Score页面的列表适配器
 *
 * 1.获取适配器视图
 * 2.获取视图中的组建
 * 3.给组建赋值
 */

public class ScoreAdapter extends BaseAdapter {

    //定义适配的列表数据
    private List<Score> list = new ArrayList<>();

    //LayoutInflater将布局文件实例化为View对象
    private LayoutInflater layoutInflater;

    //适配器的构造方法
    public ScoreAdapter(List<Score> scores, Context context){
        list = scores;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 获取列表项数据项个数
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 获取列表项内容
     * @param i
     * @return
     */
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //获取适配器视图
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //1.获取适配器视图
        View v = layoutInflater.inflate(R.layout.list_item,null);

        // 2.获取视图中的组建
        TextView textView = (TextView) v.findViewById(R.id.EN);
        TextView textView1 = (TextView) v.findViewById(R.id.Score);

        //获得列表项的数据项数据
        Score score = list.get(i);

        //3.给组建赋值
        textView.setText("反馈标题:"+score.EN);
        textView1.setText("内容:"+score.SCORE);

        return v;
    }
}
