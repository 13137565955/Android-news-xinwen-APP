package com.example.administrator.ex5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.administrator.ex5_1.adapter.MyAdapter;
import com.example.administrator.ex5_1.bean.Fruit;
import com.example.administrator.ex5_1.bean.FruitResource;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rv_fruit;
    private ArrayList<Fruit> list =new ArrayList<>();
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rv_fruit= (RecyclerView) findViewById(R.id.rv_fruit);
        FruitResource.loadData(list);
        adapter=new MyAdapter(list);
        rv_fruit.setAdapter(adapter);

        LinearLayoutManager manager=new LinearLayoutManager(RecyclerViewActivity.this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        rv_fruit.setLayoutManager(manager);
    }
}
