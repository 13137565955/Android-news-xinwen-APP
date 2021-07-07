package com.example.ex5_1_1.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex5_1_1.Main1Activity;
import com.example.ex5_1_1.R;
import com.example.ex5_1_1.TijiaofankuiActivity;
import com.example.ex5_1_1.login;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    private Button youyong,wuyong;
    private TextView tijiao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        youyong = (Button) view.findViewById(R.id.youyong);
        wuyong = (Button) view.findViewById(R.id.wuyong);
        tijiao = (TextView) view.findViewById(R.id.tijiao);
        youyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youyong.setTextColor(Color.RED);
                wuyong.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), "谢谢您的反馈", Toast.LENGTH_SHORT).show();
            }
        });
        wuyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youyong.setTextColor(Color.BLACK);
                wuyong.setTextColor(Color.RED);
                Toast.makeText(getActivity(), "很遗憾，您可以提交问题反馈~", Toast.LENGTH_SHORT).show();
            }
        });
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "反馈成功~", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),TijiaofankuiActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
