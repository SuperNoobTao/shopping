package com.cenyol.example.service;

/**
 * Created by Administrator on 2017/3/30.
 */

import com.cenyol.example.repository.UserRepo;
import com.cenyol.example.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;



    public String login(String username,String pwd){
        String password = userRepo.usernameExsit(username);
        if (StringUtils.isEmpty(password)) {
            return StringUtil.FAILED;
        }else{
            if (pwd.equals(password)) {
                return StringUtil.SUCCESS;
            }else{
                return StringUtil.FAILED;
            }
        }
    }
}
