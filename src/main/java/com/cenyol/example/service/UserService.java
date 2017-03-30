package com.cenyol.example.Service;

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
}
