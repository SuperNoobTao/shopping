package com.cenyol.example.service;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.PromotionEntity;
import com.cenyol.example.repository.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by shentao on 2017/5/7.
 */
@Service
public class PromotionService {


    @Autowired
    PromotionRepo promotionRepo;

    @Transactional
    public PromotionEntity add(PromotionEntity promotionEntity) {
        //保存到数据库
        PromotionEntity pro = promotionRepo.save(promotionEntity);
        //刷新
        promotionRepo.flush();
        return pro;
    }
}
