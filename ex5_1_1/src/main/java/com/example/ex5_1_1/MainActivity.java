package com.example.ex5_1_1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ex5_1_1.adapter.NewsAdapter;
import com.example.ex5_1_1.bean.News;
import com.example.ex5_1_1.task.NewsTask;

import java.util.ArrayList;

import static com.example.ex5_1_1.R.layout.item_layout;

public class MainActivity extends AppCompatActivity {
    ListView lv_news;
    ArrayList<News> list=new ArrayList<>();
    NewsAdapter adapter;
    String url="https://api.apiopen.top/getWangYiNews?page=";
    int curPage=1;
    boolean isloading=true,isDown=false;
    //侧边导航
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private FloatingActionButton fab;
    ////
    String cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_news= (ListView) findViewById(R.id.lv_news);
        loadData();
        adapter=new NewsAdapter(MainActivity.this,item_layout,list);
        lv_news.setAdapter(adapter);

       // lv_news.setOnClickListener();
       // lv_news.setOnItemClickListener();
        lv_news.setOnScrollListener(new AbsListView.OnScrollListener() {
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
                }else{
                    isDown=false;
                }
            }
        });
        //侧边栏导航栏等
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这是网易新闻！！！", Toast.LENGTH_SHORT).show();
                Snackbar.make(v,"网易新闻真好看！",Snackbar.LENGTH_SHORT)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "按钮被点击了！", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        navView = (NavigationView) findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.call:
//                        Toast.makeText(Main2Activity.this, "call", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.friends:
                        Intent intent2 = new Intent(MainActivity.this,Mycomments.class);
                        startActivity(intent2);
                        break;
                    case R.id.location:
                        Intent intent3 = new Intent(MainActivity.this,login.class);
                        startActivity(intent3);
                        break;
                    case R.id.source:
                        Intent intent4 = new Intent(MainActivity.this,TijiaofankuiActivity.class);
                        startActivity(intent4);
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBar bar = getSupportActionBar();
        if (bar!=null){
            bar.setDisplayHomeAsUpEnabled(true);
            bar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }

    private void loadData() {
        if (isloading) {
            isloading = false;
            new NewsTask(new NewsTask.CallBack() {
                @Override
                public void getResult(ArrayList<News> result) {
                    list.addAll(result);
                    adapter.notifyDataSetChanged();
                }
            }).execute(url + curPage);
            curPage++;
            isloading = true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);/*得到打气筒 打入*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "反馈", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,TijiaofankuiActivity.class);
                startActivity(intent);
                break;
            case R.id.delete:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
//                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(MainActivity.this,Feedback.class);
                startActivity(intent5);
                break;
        }
        return true;
    }
}
