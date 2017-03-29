package com.cenyol.example.repository;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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



}
