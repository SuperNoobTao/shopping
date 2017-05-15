package com.cenyol.example.service;

import com.cenyol.example.model.SellerEntity;
import com.cenyol.example.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerService {

    @Autowired
    private SellerRepo sellerRepo;


    public SellerEntity login(String username, String pwd){
        SellerEntity sellerEntity = sellerRepo.SellerExsit(username);

        if (sellerEntity==null) {
            return null;
        }else{
            if (pwd.equals(sellerEntity.getMypassword())) {
                return sellerEntity;
            }else{
                return null;
            }
        }
    }

}
