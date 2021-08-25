package org.airflare.ebborize.controller;

import org.airflare.ebborize.pojo.UserRepository;
import org.airflare.ebborize.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserRepositoryController {

    UserRepositoryService service;

    @Autowired
    public void setService(UserRepositoryService service) {
        this.service = service;
    }

    @RequestMapping("/createRepo/{userId}/{repoName}")
    public String createRepo(@PathVariable("userId") int userId,@PathVariable("repoName") String repoName){
        int id = service.createRepo(userId,repoName);
        return "用户： "+userId +"成功创建仓库 "+ repoName +" 仓库id为 "+id;
    }

    @RequestMapping("/selectRepo/{userId}")
    public String getUserRepo(@PathVariable("userId") int userId){
        List<UserRepository> repos = service.selectRepoByUserId(userId);
        for(UserRepository repo : repos){
            System.out.println(repo.toString());
        }
        return Arrays.toString(repos.toArray());
    }
}
