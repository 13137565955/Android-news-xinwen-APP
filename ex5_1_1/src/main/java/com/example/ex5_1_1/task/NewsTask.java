package com.example.ex5_1_1.task;

import android.os.AsyncTask;

import com.example.ex5_1_1.bean.News;
import com.example.ex5_1_1.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Response;

/**
 * Created by Administrator on 2021/4/20 0020.
 */

public class NewsTask extends AsyncTask<String,Void,ArrayList<News>>{
    CallBack back;

    public NewsTask(CallBack back) {
        this.back = back;
    }

    //  params：可变参数,参数个数根据调用时所传数据
    @Override
    protected ArrayList<News> doInBackground(String... params) {
        ArrayList<News> result=null;
        Response response= Utils.execute(params[0]);
        try {
            String data=response.body().string();//json数据
            result=Utils.parse(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<News> newses) {
        super.onPostExecute(newses);
        if (back!=null)back.getResult(newses);
    }
    public interface CallBack{
        public void getResult(ArrayList<News> result);
    }
}


