package org.airflare.ebborize.service;

import org.airflare.ebborize.mapper.UserMapper;
import org.airflare.ebborize.pojo.User;
import org.airflare.ebborize.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(String name,String pwd){
        String salt = PasswordUtil.generateSalt();
        String formedPassword = PasswordUtil.getFormedPassword(pwd,salt);
        User user = new User();
        user.setUserName(name);
        user.setPassword(formedPassword);
        user.setSalt(salt);
        user.setRegisTime(new Date());
        userMapper.addUser(user);
        return user.getUserId();
    }

    public User getUser(String username){
        return userMapper.getUserByName(username);
    }

    public User getUserByNameAndPassword(String name,String pwd){
        User user = getUser(name);
        if(user==null) return null;
        String salt = user.getSalt();
        String formedPwd = PasswordUtil.getFormedPassword(pwd,salt);
        if(formedPwd.equals(user.getPassword())){
            return user;
        }else{
            return null;
        }
    }
}
