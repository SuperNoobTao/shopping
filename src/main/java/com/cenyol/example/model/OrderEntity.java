package com.cenyol.example.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by shentao on 2017/3/29.
 */
@Entity
@javax.persistence.Table(name = "order", schema = "shopping", catalog = "")
public class OrderEntity {
    private int orderid;

    @Id
    @javax.persistence.Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    private int userid;

    @Basic
    @javax.persistence.Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private int productid;

    @Basic
    @javax.persistence.Column(name = "productid")
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    private String username;

    @Basic
    @javax.persistence.Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String productname;

    @Basic
    @javax.persistence.Column(name = "productname")
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    private String orderaddress;

    @Basic
    @javax.persistence.Column(name = "orderaddress")
    public String getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(String orderaddress) {
        this.orderaddress = orderaddress;
    }

    private double orderprice;

    @Basic
    @javax.persistence.Column(name = "orderprice")
    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    private int ordernum;

    @Basic
    @javax.persistence.Column(name = "ordernum")
    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    private String ordertel;

    @Basic
    @javax.persistence.Column(name = "ordertel")
    public String getOrdertel() {
        return ordertel;
    }

    public void setOrdertel(String ordertel) {
        this.ordertel = ordertel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderid != that.orderid) return false;
        if (userid != that.userid) return false;
        if (productid != that.productid) return false;
        if (Double.compare(that.orderprice, orderprice) != 0) return false;
        if (ordernum != that.ordernum) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (productname != null ? !productname.equals(that.productname) : that.productname != null) return false;
        if (orderaddress != null ? !orderaddress.equals(that.orderaddress) : that.orderaddress != null) return false;
        if (ordertel != null ? !ordertel.equals(that.ordertel) : that.ordertel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderid;
        result = 31 * result + userid;
        result = 31 * result + productid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (productname != null ? productname.hashCode() : 0);
        result = 31 * result + (orderaddress != null ? orderaddress.hashCode() : 0);
        temp = Double.doubleToLongBits(orderprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ordernum;
        result = 31 * result + (ordertel != null ? ordertel.hashCode() : 0);
        return result;
    }
}
