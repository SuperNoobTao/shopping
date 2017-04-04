package com.cenyol.example.repository;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shentao on 2017/3/29.
 */
@Repository // 添加注解
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where p.producttype=:producttype")
    public List<ProductEntity> getProductS(@Param("producttype") String id);

    @Modifying // 说明该方法是修改操作

    // @Param注解用于提取参数
    @Query("update ProductEntity p set p.description=:description, p.imgurl=:imgurl, " +
                                       "p.price=:price,p.productname=:productname,p.producttype=:producttype," +
                                       "p.salenum=:salenum  where p.productid=:productid")
    public void updatePro(@Param("description") String description,
                           @Param("imgurl") String imgurl,
                           @Param("price") String price,
                           @Param("productname") Integer productname,
                           @Param("producttype") String producttype,
                           @Param("salenum") int salenum,
                           @Param("productid") int productid);

}
