package com.cenyol.example.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sjj on 2015/10/24 0024.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "userid", nullable = false, insertable = true, updatable = true)
    private int id;
    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 45)
    private String username;

    @Basic
    @Column(name = "password", nullable = true, insertable = true, updatable = true, length = 45)
    private String password;

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 45)
    private String address;

    @Basic
    @Column(name = "tel", nullable = true, insertable = true, updatable = true, length = 45)
    private String tel;

    @Basic
    @Column(name = "money", nullable = true, insertable = true, updatable = true, length = 45)
    private double money;

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 45)
    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
