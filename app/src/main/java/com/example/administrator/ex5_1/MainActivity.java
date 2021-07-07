package com.example.administrator.ex5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.ex5_1.adapter.FruitAdapter;
import com.example.administrator.ex5_1.bean.Fruit;
import com.example.administrator.ex5_1.bean.FruitResource;
import com.example.administrator.ex5_1.task.FruitTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_fruit;
    private ArrayList<Fruit> list=new ArrayList<>();
    private FruitAdapter adapter;
    boolean isDown=false,isLoading=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_fruit= (ListView) findViewById(R.id.lv_fruit);
        FruitResource.loadData(list);
        adapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,list);
        lv_fruit.setAdapter(adapter);
        //对列表项事件处理
        lv_fruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"你选择的水果是："+list.get(i).getFruitName(),Toast.LENGTH_SHORT).show();
            }
        });
        //列表滚动的事件处理
        lv_fruit.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(isDown&&i==SCROLL_STATE_IDLE){
                    loadData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if(i+i1==i2){
                    isDown=true;
                }
                else{
                    isDown=false;
                }
            }
        });
    }

    private void loadData() {
        if(isLoading){
            isLoading=false;
            //创建并执行异步任务
            new FruitTask(new FruitTask.CallBack() {
                @Override
                public void getResult(ArrayList<Fruit> result) {
                    list.addAll(result);
                    adapter.notifyDataSetChanged();//通知适配器数据发生改变
                }
            }).execute();

            isLoading=true;
        }
    }
}
