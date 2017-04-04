package com.cenyol.example.service;

/**
 * Created by Administrator on 2017/3/30.
 */

import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.UserRepo;
import com.cenyol.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;



    public UserEntity login(String username,String pwd){
        UserEntity userEntity = userRepo.usernameExsit(username);

        if (userEntity==null) {
            return null;
        }else{
            if (pwd.equals(userEntity.getPassword())) {
                return userEntity;
            }else{
                return null;
            }
        }
    }


    public String register(UserEntity user){
        UserEntity userEntity = userRepo.usernameExsit(user.getUsername());

        if (userEntity!=null) {
            return "10000";//用户名已存在
        }else{

            UserEntity u =  userRepo.save(user);
            if (u!=null) {
                return "00000";//添加成功
            }else{
                return "20000";//数据库错误
            }
        }

    }
}
