package com.example.administrator.ex5_1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ex5_1.R;
import com.example.administrator.ex5_1.bean.Fruit;

import java.util.ArrayList;

/**
 * Created by Administrator on 2021/4/13 0013.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<Fruit> list;//列表的数据源
    public MyAdapter(ArrayList<Fruit> list) {
        this.list = list;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        MyAdapter.ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit= list.get(position);//获取要显示列表项的数据
        holder.fruitImage.setImageResource(fruit.getFuirtImgId());
        holder.carImage.setImageResource(fruit.getCarImgId());
        holder.fruitName.setText(fruit.getFruitName());
        holder.fruitPrice.setText(fruit.getFruitPrice()+"元/kg");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        ImageView carImage;
        TextView fruitName;
        TextView fruitPrice;
        public ViewHolder(View view) {
            super(view);
            fruitImage= (ImageView) view.findViewById(R.id.fruit_img);
            carImage= (ImageView) view.findViewById(R.id.car_img);
            fruitName= (TextView) view.findViewById(R.id.fruit_name);
            fruitPrice= (TextView) view.findViewById(R.id.furit_price);
        }
    }
}
