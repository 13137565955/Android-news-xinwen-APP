package com.example.administrator.ex5_1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.ex5_1.R;
import com.example.administrator.ex5_1.bean.Fruit;

import java.util.List;

/**
 * Created by Administrator on 2021/4/6 0006.
 */

public class FruitAdapter extends ArrayAdapter {
    int item_layout_id;//列表项布局的ID
    public FruitAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        item_layout_id=resource;
    }
//显示（加载）每个列表项的时候，调用getview（）方法
    //1加载列表项布局
    //2为列表项中各个控件设置要显示的数据
    //position 要显示列表项的位置（序号）
    //convertView 滑出屏幕的列表项视图

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        //getContext（） 获取上下文
        //LayoutInflater.from 从当前上下文中获取布局填充器（充气筒）
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(item_layout_id,parent,false);
            holder=new ViewHolder(view);
            view.setTag(holder);//将列表项视图与列表项事件拥有者绑定
        }else{
            view= convertView;//重复利用滑出屏幕的列表项视图
            holder= (ViewHolder) view.getTag();
        }

        Fruit fruit= (Fruit) getItem(position);//获取要显示列表项的数据
//        ImageView fruitImage= (ImageView) view.findViewById(R.id.fruit_img);
//        ImageView carImage= (ImageView) view.findViewById(R.id.car_img);
//        TextView fruitName= (TextView) view.findViewById(R.id.fruit_name);
//        TextView fruitPrice= (TextView) view.findViewById(R.id.furit_price);
        holder.fruitImage.setImageResource(fruit.getFuirtImgId());
        holder.carImage.setImageResource(fruit.getCarImgId());
        holder.fruitName.setText(fruit.getFruitName());
        holder.fruitPrice.setText(fruit.getFruitPrice()+"元/kg");

        return view;
    }
    class ViewHolder{
        ImageView fruitImage;
        ImageView carImage;
        TextView fruitName;
        TextView fruitPrice;
        public ViewHolder(View view){
             fruitImage= (ImageView) view.findViewById(R.id.fruit_img);
             carImage= (ImageView) view.findViewById(R.id.car_img);
             fruitName= (TextView) view.findViewById(R.id.fruit_name);
             fruitPrice= (TextView) view.findViewById(R.id.furit_price);
            //对列表项中的购物车进行事件处理
            carImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),fruitName.getText()+"已加入购物车",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
