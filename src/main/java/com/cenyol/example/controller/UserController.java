package com.cenyol.example.controller;


import com.cenyol.example.model.OrderEntity;
import com.cenyol.example.model.ProductEntity;
import com.cenyol.example.model.ShoppingCartEntity;
import com.cenyol.example.model.UserEntity;
import com.cenyol.example.repository.OrderRepo;
import com.cenyol.example.repository.UserRepo;
import com.cenyol.example.service.ProductService;
import com.cenyol.example.service.ShoppingCartService;
import com.cenyol.example.utils.StringUtil;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.AttributeOverride;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
public class UserController {

    // 自动装配
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private com.cenyol.example.service.UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    // 用户管理
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap modelMap){
        // 找到user表里面的所有记录
        List<UserEntity> userEntityList = userRepository.findAll();

        // 将所有的记录传递给返回的jsp页面
        modelMap.addAttribute("userList", userEntityList);

        // 返回pages目录下的userManage.jsp
        return "userManage";
    }

    // 添加用户表单页面
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(){
        return "addUser";
    }

    // 添加用户处理
    @RequestMapping(value = "/addUserPost", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity){
        // 向数据库添加一个用户
        userRepository.save(userEntity);

        // 向数据库添加一个用户，并将内存中缓存区的数据刷新，立即写入数据库，之后才可以进行访问读取
        userRepository.saveAndFlush(userEntity);

        // 返回重定向页面
        return "redirect:/users";
    }

//     查看用户详细信息
//     @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
//     例如：访问 localhost:8080/showUser/1 ，将匹配 userId = 1
    @RequestMapping(value = "/showUser/{userId}", method = RequestMethod.GET)
    public String showUser( @PathVariable("userId") Integer userId, ModelMap modelMap ){
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "userDetail";
    }

    // 更新用户信息页面
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") Integer userId, ModelMap modelMap){
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "updateUser";
    }
    // 处理用户修改请求
//    @RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
//    public String updateUserPost(@ModelAttribute("user") UserEntity userEntity){
//        userRepository.updateUser(
//                userEntity.getFirstName(),
//                userEntity.getLastName(),
//                userEntity.getPassword(),
//                userEntity.getId()
//        );
//        return "redirect:/users";
//    }

//    // 删除用户
//    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
//    public String deleteUser(@PathVariable("userId") Integer userId){
//        // 删除id为userId的用户
//        userRepository.delete(userId);
//        // 立即刷新数据库
//        userRepository.flush();
//        return "redirect:/users";
//    }


    // 用户详细信息界面
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(HttpSession httpSession,ModelMap modelMap){
//        从Session中读取用户 没有则返回登录页面
        UserEntity user = (UserEntity) httpSession.getAttribute("user");
        if (user==null) {
            return "login";
        }
        List<OrderEntity> orderEntity = orderRepo.getOrderByU(user.getId());
        modelMap.addAttribute("userinfo",user);
        modelMap.addAttribute("order",orderEntity);
        return "user";
    }

    //用户登陆，登陆成功则刷新页面(未完成，应该把user对象放进session中)
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public  HashMap<String, String> login(String username,String password,HttpSession httpSession){
        HashMap<String,String> map = new HashMap<String, String>();
        UserEntity user = userService.login(username,password);
        if (user!=null) {
            map.put("code","true");
            httpSession.setAttribute("user", user);

        }
        else{
            map.put("code","false");
        }
        return map;
    }





    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> register(UserEntity userEntity){
        HashMap<String,String>  map = new HashMap<String, String>();
        userEntity.setMoney(1000);
        String result = userService.register(userEntity);
        map.put("code",result);
        return map;
    }

}