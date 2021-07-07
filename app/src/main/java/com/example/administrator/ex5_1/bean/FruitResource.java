package com.example.administrator.ex5_1.bean;

import com.example.administrator.ex5_1.R;

import java.util.ArrayList;


/**
 * Created by b on 2021/4/5.
 */

public class FruitResource {
    public static int[] fruitImageIds = {R.drawable.apple_pic, R.drawable.banana_pic,
            R.drawable.cherry_pic, R.drawable.grape_pic, R.drawable.mango_pic, R.drawable.orange_pic,
            R.drawable.pear_pic, R.drawable.pineapple_pic, R.drawable.strawberry_pic, R.drawable.watermelon_pic
    };
    public static String[] friutNames = {"apple", "banana", "cherry", "grape", "mango",
            "orange", "pear", "pineapple", "strawberry", "watermelon"};
    public static void loadData(ArrayList<Fruit> list) {
        for(int i = 0; i< FruitResource.friutNames.length; i++){
            double price=5+((int)(Math.random()*100))/10.0;
            Fruit item=new Fruit(FruitResource.friutNames[i],
                    FruitResource.fruitImageIds[i],price,R.drawable.shopping_car);
            list.add(item);
        }
    }
}
