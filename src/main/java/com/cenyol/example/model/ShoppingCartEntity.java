package com.cenyol.example.model;

import javax.persistence.*;

/**
 * Created by shentao on 2017/3/29.
 */
@Entity
@Table(name = "shoppingcart")
public class ShoppingCartEntity {

    @Id
    @Column(name = "shopppingcartid", nullable = false, insertable = true, updatable = true)
    private int shopppingcartid;

    @Basic
    @Column(name = "userid", nullable = true, insertable = true, updatable = true, length = 45)
    private int userid;

    @Basic
    @Column(name = "productid", nullable = true, insertable = true, updatable = true, length = 45)
    private int productid;

    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 45)
    private String username;

    @Basic
    @Column(name = "productname", nullable = true, insertable = true, updatable = true, length = 45)
    private String productname;

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, length = 45)
    private double price;

    @Basic
    @Column(name = "imgurl", nullable = true, insertable = true, updatable = true, length = 45)
    private String imgurl;

    public int getShopppingcartid() {
        return shopppingcartid;
    }

    public void setShopppingcartid(int shopppingcartid) {
        this.shopppingcartid = shopppingcartid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
