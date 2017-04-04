package com.cenyol.example.service;

import com.cenyol.example.model.ShoppingCartEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    public boolean
    add(ShoppingCartEntity shoppingCartEntity,int userid){

        ShoppingCartEntity cart = shoppingCartRepo.getInfoByPID(shoppingCartEntity.getProductid(),userid);
        if(cart!=null){
            return false;
        }else{
            shoppingCartRepo.save(shoppingCartEntity);
            return true;
        }

    }



    public boolean cartExist(int productid,int userid){

        ShoppingCartEntity cart = shoppingCartRepo.getInfoByPID(productid,userid);
        if(cart!=null){
            return false;
        }else{
            return true;
        }

    }
}
