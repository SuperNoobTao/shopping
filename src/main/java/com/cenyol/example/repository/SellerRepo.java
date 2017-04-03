package com.cenyol.example.repository;

import com.cenyol.example.model.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by shentao on 2017/3/29.
 */
@Repository // 添加注解
public interface SellerRepo extends JpaRepository<SellerEntity, Integer> {


    @Query("select u from SellerEntity u where u.myusername=:myusername")
    public SellerEntity SellerExsit(@Param("myusername")String myusername);
}
