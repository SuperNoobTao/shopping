package com.cenyol.example.repository;

import com.cenyol.example.model.SellerEntity;
import com.cenyol.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shentao on 2017/3/29.
 */
@Repository // 添加注解
public interface SellerRepo extends JpaRepository<SellerEntity, Integer> {
}
