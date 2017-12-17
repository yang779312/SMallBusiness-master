package com.liumeng.smallbusiness;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/11/13.
 */
@Entity
public class Commodity {
    @Id
    private Long id; // id
    private String name; // 名字
    private String title; // 标题
    private double price; // 价格
    private String quantifier;//量词 箱/袋/盒 ...
    private int reserve;// 库存
    private int sales; // 销量
    private String imgUrl;// 图片链接
    private String des; // 描述
    private String detail; // 描述

    @Generated(hash = 894075397)
    public Commodity(Long id, String name, String title, double price,
            String quantifier, int reserve, int sales, String imgUrl, String des,
            String detail) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
        this.quantifier = quantifier;
        this.reserve = reserve;
        this.sales = sales;
        this.imgUrl = imgUrl;
        this.des = des;
        this.detail = detail;
    }

    @Generated(hash = 1425960444)
    public Commodity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(String quantifier) {
        this.quantifier = quantifier;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
