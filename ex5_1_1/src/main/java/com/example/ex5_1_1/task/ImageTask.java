package com.example.ex5_1_1.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.ex5_1_1.utils.Utils;

import java.io.IOException;

import okhttp3.Response;


/**
 * Created by Administrator on 2021/4/20 0020.
 */

public class ImageTask extends AsyncTask <String,Void,Bitmap>{
    ImageTask.CallBack back;

    public ImageTask(CallBack back) {
        this.back = back;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap image=null;
        Response response= Utils.execute(params[0]);
        try {
            byte[] bytes=response.body().bytes();
//            BitmapFactory解码
            image= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(back!=null)back.getResult(bitmap);
    }
    public interface CallBack{
        public void getResult(Bitmap result);
    }
}
