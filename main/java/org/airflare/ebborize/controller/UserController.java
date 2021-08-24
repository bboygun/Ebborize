package org.airflare.ebborize.controller;

import org.airflare.ebborize.pojo.User;
import org.airflare.ebborize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login/{name}/{pwd}")
    public String login(@PathVariable("name") String name,@PathVariable("pwd") String pwd){
        User user = userService.getUserByNameAndPassword(name,pwd);
        System.out.println(user.toString());
        if(user!=null){
            return "用户： "+user.getUserName()+" 登陆成功！";
        }else{
            return "用户名或密码错误！";
        }
    }
}
