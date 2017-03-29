package com.cenyol.example.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by shentao on 2017/3/29.
 */
@Entity
@javax.persistence.Table(name = "content", schema = "shopping", catalog = "")
public class ContentEntity {
    private int contentid;

    @Id
    @javax.persistence.Column(name = "contentid")
    public int getContentid() {
        return contentid;
    }

    public void setContentid(int contentid) {
        this.contentid = contentid;
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

    private String contentmain;

    @Basic
    @javax.persistence.Column(name = "contentmain")
    public String getContentmain() {
        return contentmain;
    }

    public void setContentmain(String contentmain) {
        this.contentmain = contentmain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentEntity that = (ContentEntity) o;

        if (contentid != that.contentid) return false;
        if (userid != that.userid) return false;
        if (productid != that.productid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (contentmain != null ? !contentmain.equals(that.contentmain) : that.contentmain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contentid;
        result = 31 * result + userid;
        result = 31 * result + productid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (contentmain != null ? contentmain.hashCode() : 0);
        return result;
    }
}
