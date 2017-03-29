package com.cenyol.example.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.swing.*;

/**
 * Created by shentao on 2017/3/29.
 */
public class SellerEntity {

    @Id
    @Column(name = "sellerid", nullable = false, insertable = true, updatable = true)
    private int sellerid;

    @Id
    @Column(name = "myusername", nullable = false, insertable = true, updatable = true)
    private String myusername;

    @Id
    @Column(name = "mypassword", nullable = false, insertable = true, updatable = true)
    private String mypassword;

    @Id
    @Column(name = "earning", nullable = false, insertable = true, updatable = true)
    private double earning;


    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public String getMyusername() {
        return myusername;
    }

    public void setMyusername(String myusername) {
        this.myusername = myusername;
    }

    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }
}
