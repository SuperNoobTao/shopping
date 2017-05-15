package com.cenyol.example.service;

import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.PromotionEntity;
import com.cenyol.example.repository.ProductRepo;
import com.cenyol.example.repository.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.font.TrueTypeFont;

import java.util.Date;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PromotionRepo promotionRepo;



    public List<ProductEntity> prolist(String type){
        List<ProductEntity> list = productRepo.getProductS(type);
        for (int i=0;i<list.size();i++) {
            Double price = promotionRepo.getPrice(new Date(),list.get(i).getProductid());
            if (price != null) {
                list.get(i).setPrice(price);
            }
        }
        return list;
    }

    public ProductEntity findOne(int id) {
        ProductEntity productEntity = productRepo.findOne(id);
        Double price = promotionRepo.getPrice(new Date(), id);
        if (price != null) {
            productEntity.setPrice(price);

        }
        return productEntity;
    }





    @Transactional
    public ProductEntity add(ProductEntity productEntity) {
        //保存到数据库
        ProductEntity pro = productRepo.save(productEntity);
        //刷新
        productRepo.flush();
        return pro;
    }

    @Transactional
    public ProductEntity update(ProductEntity proparam) {
        int id = proparam.getProductid();
        //根据id取得对象
        ProductEntity productEntity = productRepo.findOne(id);

        if (proparam.getImgurl().equals("")) {
            //编辑属性
            productEntity.setDescription(proparam.getDescription());
            productEntity.setPrice(proparam.getPrice());
            productEntity.setProductname(proparam.getProductname());
            productEntity.setProducttype(proparam.getProducttype());
            productEntity.setSalenum(proparam.getSalenum());
        } else {
            //编辑属性
            productEntity.setDescription(proparam.getDescription());
            productEntity.setPrice(proparam.getPrice());
            productEntity.setImgurl(proparam.getImgurl());
            productEntity.setProductname(proparam.getProductname());
            productEntity.setProducttype(proparam.getProducttype());
            productEntity.setSalenum(proparam.getSalenum());
        }

        //更新数据库
        productRepo.save(productEntity);

        //刷新
        productRepo.flush();

        return productRepo.save(productEntity);

    }

    @Transactional
    public boolean del(int productid) {
        //删除数据库
        productRepo.delete(productid);
        //刷新
        productRepo.flush();

        if (productRepo.findOne(productid) != null) {
            return false;
        } else {
            return true;
        }
    }

}
