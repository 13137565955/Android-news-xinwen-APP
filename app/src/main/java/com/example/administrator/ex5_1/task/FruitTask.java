package com.example.administrator.ex5_1.task;

import android.os.AsyncTask;

import com.example.administrator.ex5_1.bean.Fruit;
import com.example.administrator.ex5_1.bean.FruitResource;

import java.util.ArrayList;

/**
 * Created by Administrator on 2021/4/13 0013.
 */
/**
 * 三个泛型
 * 1：执行异步任务时所传参数的类型，如无参数则为Void
 * 2:如果需要显示异步任务的进度，则可以设为Integer，否则设为Void
 * 3:异步任务执行结束后所得到的结果的类型
 *执行顺序：
 * onPreExecute()->doInBackground()，如果需要显示异步任务执行的进度，则执行onProgressUpate()
 * ,否则跳过该方法，最后执行onPostExecute()
 *异步任务所得到的结果（数据）传递路径
 * 在doInBackgroud()方法中获取结果并传给onPostExecute（）的方法的参数
 *  */
public class FruitTask extends AsyncTask<Void,Void,ArrayList<Fruit>> {
    public CallBack back;

    public FruitTask(CallBack back) {
        this.back = back;
    }


    @Override
    protected void onPreExecute() {//主线程
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Fruit> doInBackground(Void... voids) {//子线程
        ArrayList<Fruit> list=new ArrayList<>();
        FruitResource.loadData(list);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onProgressUpdate(Void... values) {//主线程
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<Fruit> fruits) {//主线程
        super.onPostExecute(fruits);
        if (back!=null)back.getResult(fruits);//接口回调

    }

    //创建回调接口
    public interface CallBack{
        public abstract void getResult(ArrayList<Fruit> result);
    }
}
