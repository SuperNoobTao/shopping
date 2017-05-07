package com.cenyol.example.repository;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by shentao on 2017/4/9.
 */
@Repository
public interface PromotionRepo extends JpaRepository<PromotionEntity, Integer> {

    @Query("select p.price from PromotionEntity p where p.startdate<=:date and p.finishdate>=:date and p.productid=:productid")
    public Double getPrice(@Param("date") Date date,
                              @Param("productid") int productid);




}
