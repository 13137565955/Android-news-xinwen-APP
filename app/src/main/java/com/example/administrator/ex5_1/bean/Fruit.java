package com.example.administrator.ex5_1.bean;

/**
 * Created by Administrator on 2021/4/6 0006.
 */

public class Fruit {
    private String fruitName;
    private double fruitPrice;
    private int fruitImgId;
    private int carImgId;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public int getFuirtImgId() {
        return fruitImgId;
    }

    public void setFuirtImgId(int fuirtImgId) {
        this.fruitImgId = fuirtImgId;
    }

    public int getCarImgId() {
        return carImgId;
    }

    public void setCarImgId(int carImgId) {
        this.carImgId = carImgId;
    }

    public Fruit(String fruitName, int fruitImgId, double fruitPrice, int carImgId) {
        this.fruitName = fruitName;
        this.fruitImgId = fruitImgId;
        this.fruitPrice = fruitPrice;
        this.carImgId = carImgId;
    }
}
