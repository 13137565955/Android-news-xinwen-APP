package com.example.ex5_1_1.utils;

import com.example.ex5_1_1.bean.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2021/4/20 0020.
 */

public class Utils {
    static OkHttpClient client=new OkHttpClient();
    public static Response execute(String url){
        Request request=new Request.Builder()
                .url(url)
                .build();
        try {
            Response response=client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将字符串形式表示的数据进行解析，返回一批列表项数据*/
    public static ArrayList<News> parse(String data){
        ArrayList<News> result =new ArrayList<>();
        try {
            JSONObject object=new JSONObject(data);//第一步
            JSONArray array=object.getJSONArray("result");
            for(int i=0;i<array.length();i++){
                JSONObject object_in=array.getJSONObject(i);
                String title=object_in.getString("title");
                String passtime=object_in.getString("passtime");
                String image=object_in.getString("image");
                String path=object_in.getString("path");
                News news=new News(title,passtime,image,path);
                result.add(news);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
