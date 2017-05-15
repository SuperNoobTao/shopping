package com.cenyol.example.repository;

import com.cenyol.example.model.OrderEntity;
import com.cenyol.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // 添加注解
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

    @Query("select o from OrderEntity o where o.userid=:userid")
    public List<OrderEntity> getOrderByU(@Param("userid") int id);

    @Modifying
    @Query("update OrderEntity o set o.orderstate = :orderstate where o.orderid=:orderid")
    public void updateOrder(@Param("orderstate") int orderstate,@Param("orderid") int id);



}
