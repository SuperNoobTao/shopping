package com.cenyol.example.model;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by shentao on 2017/4/9.
 */
@Entity
@Table(name = "promotion", schema = "shopping", catalog = "")
public class PromotionEntity {
    private int id;
    private Integer productid;
    private Double price;
    private Date startdate;
    private Date finishdate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "productid")
    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "finishdate")
    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionEntity that = (PromotionEntity) o;

        if (id != that.id) return false;
        if (productid != null ? !productid.equals(that.productid) : that.productid != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (finishdate != null ? !finishdate.equals(that.finishdate) : that.finishdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productid != null ? productid.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (finishdate != null ? finishdate.hashCode() : 0);
        return result;
    }

    public PromotionEntity(Integer productid, Double price, Date startdate, Date finishdate) {
        this.productid = productid;
        this.price = price;
        this.startdate = startdate;
        this.finishdate = finishdate;
    }

    public PromotionEntity() {
    }
}
