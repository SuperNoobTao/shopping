package com.cenyol.example.model;

import javax.persistence.*;

@Entity
@Table(name = "flash", schema = "shopping", catalog = "")
public class FlashEntity {

    private int flashid;
    private int productid;
    private String bigimgurl;

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Id
    @Column(name = "flashid")
    public int getFlashid() {
        return flashid;
    }

    public void setFlashid(int flashid) {
        this.flashid = flashid;
    }

    @Basic
    @Column(name = "productid")
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "bigimgurl")
    public String getBigimgurl() {
        return bigimgurl;
    }

    public void setBigimgurl(String bigimgurl) {
        this.bigimgurl = bigimgurl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlashEntity that = (FlashEntity) o;

        if (flashid != that.flashid) return false;
        if (productid != that.productid) return false;
        if (bigimgurl != null ? !bigimgurl.equals(that.bigimgurl) : that.bigimgurl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flashid;
        result = 31 * result + productid;
        result = 31 * result + (bigimgurl != null ? bigimgurl.hashCode() : 0);
        return result;
    }
}
