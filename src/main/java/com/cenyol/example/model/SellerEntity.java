package com.cenyol.example.model;

import javax.persistence.*;

/**
 * Created by shentao on 2017/3/30.
 */
@Entity
@Table(name = "seller", schema = "shopping", catalog = "")
public class SellerEntity {
    private int sellerid;
    private String myusername;
    private String mypassword;
    private Double earning;

    @Id
    @Column(name = "sellerid")
    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    @Basic
    @Column(name = "myusername")
    public String getMyusername() {
        return myusername;
    }

    public void setMyusername(String myusername) {
        this.myusername = myusername;
    }

    @Basic
    @Column(name = "mypassword")
    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }

    @Basic
    @Column(name = "earning")
    public Double getEarning() {
        return earning;
    }

    public void setEarning(Double earning) {
        this.earning = earning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerEntity that = (SellerEntity) o;

        if (sellerid != that.sellerid) return false;
        if (myusername != null ? !myusername.equals(that.myusername) : that.myusername != null) return false;
        if (mypassword != null ? !mypassword.equals(that.mypassword) : that.mypassword != null) return false;
        if (earning != null ? !earning.equals(that.earning) : that.earning != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sellerid;
        result = 31 * result + (myusername != null ? myusername.hashCode() : 0);
        result = 31 * result + (mypassword != null ? mypassword.hashCode() : 0);
        result = 31 * result + (earning != null ? earning.hashCode() : 0);
        return result;
    }
}
