package com.cenyol.example.service;

import com.cenyol.example.model.OrderEntity;
import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.SellerEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.OrderRepo;
import com.cenyol.example.repository.ProductRepo;
import com.cenyol.example.repository.SellerRepo;
import com.cenyol.example.repository.UserRepo;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SellerRepo sellerRepo;
    @Autowired
    private ProductRepo productRepo;


    @Transactional
    public void addOrder(OrderEntity orderEntity){
        //订单保存
        orderRepo.save(orderEntity);
        //用户余额更新
        UserEntity userEntity = userRepo.findOne(orderEntity.getUserid());
        userEntity.setMoney(userEntity.getMoney()-orderEntity.getOrderprice());
        userRepo.save(userEntity);
        //卖家余额更新(卖家唯一ID)
        SellerEntity sellerEntity = sellerRepo.findOne(1);
        sellerEntity.setEarning(sellerEntity.getEarning()+orderEntity.getOrderprice());
        sellerRepo.save(sellerEntity);
        //产品销量
        ProductEntity productEntity = productRepo.findOne(orderEntity.getProductid());
        productEntity.setSalenum(productEntity.getSalenum()+orderEntity.getOrdernum());
        productRepo.save(productEntity);
    }

    @Transactional
    public boolean del(int orderid) {
        //删除数据库
        orderRepo.delete(orderid);
        //刷新
        orderRepo.flush();

        if (orderRepo.findOne(orderid) != null) {
            return false;
        } else {
            return true;
        }
    }


    @Transactional
    public void update(int orderid,int orderstate){

        //更新数据库orderstate字段
        orderRepo.updateOrder(orderstate,orderid);

    }
}
