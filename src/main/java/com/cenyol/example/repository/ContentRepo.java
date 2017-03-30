package com.cenyol.example.repository;

import com.cenyol.example.model.ContentEntity;
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
public interface ContentRepo extends JpaRepository<ContentEntity, Integer> {


    @Query("select c from ContentEntity c where c.productid=:productid ")
    public List<ContentEntity> getContentByP(@Param("productid") int id);
}
