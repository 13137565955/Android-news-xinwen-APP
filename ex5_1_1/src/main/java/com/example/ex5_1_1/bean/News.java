package com.example.ex5_1_1.bean;

/**
 * Created by Administrator on 2021/4/20 0020.
 */

public class News {
    private String title;
    private String passtime;
    private String image;
    private String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String content_url) {
        this.passtime = passtime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image_url) {
        this.image = image;
    }

    public String getpath() {
        return path;
    }

    public void setpath(String path) {
        this.path = path;
    }

    public News(String title, String passtime, String image, String path) {
        this.title = title;
        this.passtime = passtime;
        this.image = image;
        this.path = path;
    }
}
