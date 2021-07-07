package com.example.ex5_1_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Main1Activity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<View> views = new ArrayList<>();
    private MyPagerAdapter adapter;
    private LinearLayout dotsLayout;
    private TextView tv_time;
    private int time = 5;
    private boolean flag=true;
//    异步消息处理机制
//    第一步  {}匿名类  继承Handler
    Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
//        更新UI界面代码
            switch (msg.what){
                case 1 :
//                当前视图的序号+1
                    int index=(viewPager.getCurrentItem()+1)%3;
                    viewPager.setCurrentItem(index);
                    if(time ==0){
//                    跳转
                        flag = false;
                        Intent intent = new Intent(Main1Activity.this,login.class);
                        startActivity(intent);
                        finish();
                    }else{
                        tv_time.setText("  跳过 "+time +"s  ");
                    }
                    break;
            }
    }
};
    private int curPage = 0;
    private ImageView dots[]=new ImageView[3];
    private int[] imgIds=new  int[]{R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_time.bringToFront();////////////////////////////////最上层
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        dotsLayout.bringToFront();
        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main1Activity.this,login.class);
                startActivity(intent);
                time =0;
            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        页面切换
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);
//        初始化数据（侧滑容器视图）
        for (int i =0 ; i<imgIds.length;i++){
            ImageView view = new ImageView(this);
            view.setImageResource(imgIds[i]);
            views.add(view);
        }
//        初始化圆点的状态
        for (int i  = 0; i < dots.length; i++){
            dots[i] = (ImageView) dotsLayout.getChildAt(i);
            dots[i].setTag(i);
            dots[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {//view 代表单击控件对象
                    int position = (int) v.getTag();
                    viewPager.setCurrentItem(position);
                    setDots(position);
                }
            });
            dots[i].setEnabled(true);
        }
        dots[curPage].setEnabled(false);

        adapter = new MyPagerAdapter(views);
        viewPager.setAdapter(adapter);
            //        第二部  异步消息处理
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while(flag){
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                time--;
                                Message message = new Message();
//                        相当于信息
//                                Log.i("tag","run");
                                message.what = 1;
//                        发送出去
                                handler.sendMessage(message);
                            }
                        }
                    }
            ).start();
    }
    public  void setDots(int position){
        dots[curPage].setEnabled(true);
        dots[position].setEnabled(false);
        curPage = position;
    }
}
