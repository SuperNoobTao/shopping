package com.cenyol.example.repository;

import com.cenyol.example.model.ShoppingCartEntity;
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
public interface ShoppingCartRepo extends JpaRepository<ShoppingCartEntity, Integer> {

    @Query("select s from ShoppingCartEntity s where s.userid=:userid")
    public List<ShoppingCartEntity> getCartByU(@Param("userid") int id);
}
