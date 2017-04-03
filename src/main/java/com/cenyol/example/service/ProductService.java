package com.cenyol.example.service;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public void add(ProductEntity productEntity){
        //保存到数据库
        productRepo.save(productEntity);

        //刷新
        productRepo.flush();
    }

    @Transactional
    public void update(ProductEntity proparam){
        int id = proparam.getProductid();
        //根据id取得对象
        ProductEntity productEntity = productRepo.findOne(id);

        //编辑属性
        productEntity.setDescription(proparam.getDescription());
        productEntity.setImgurl(proparam.getImgurl());
        productEntity.setPrice(proparam.getPrice());
        productEntity.setProductname(proparam.getProductname());
        productEntity.setProducttype(proparam.getProducttype());
        productEntity.setSalenum(proparam.getSalenum());

        //更新数据库
        productRepo.save(productEntity);

        //刷新
        productRepo.flush();

    }

    @Transactional
    public void del(int productid){
        //删除数据库
        productRepo.delete(productid);
        //刷新
        productRepo.flush();
    }

}
