package com.cenyol.example.repository;

import com.cenyol.example.model.FlashEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wqj on 2017/5/8.
 */
@Repository
public interface FlashRepo  extends JpaRepository<FlashEntity, Integer> {


}
