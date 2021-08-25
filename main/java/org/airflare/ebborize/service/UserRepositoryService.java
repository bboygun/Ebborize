package org.airflare.ebborize.service;

import org.airflare.ebborize.mapper.UserRepositoryMapper;
import org.airflare.ebborize.pojo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserRepositoryService {

    UserRepositoryMapper userRepositoryMapper;

    @Autowired
    public void setUserRepositoryMapper(UserRepositoryMapper userRepositoryMapper) {
        this.userRepositoryMapper = userRepositoryMapper;
    }

    public int createRepo(int userid,String repoName){
        UserRepository userRepository = new UserRepository();
        userRepository.setRepositoryName(repoName);
        userRepository.setUserId(userid);
        Date createDate = new Date();
        userRepository.setCreateTime(createDate);
        userRepository.setLastModifiedTime(createDate);
        userRepositoryMapper.insertRepo(userRepository);
        return userRepository.getRepositoryId();
    }

    public List<UserRepository> selectRepoByUserId(int userid){
        return userRepositoryMapper.getRepoByUserId(userid);
    }

    public void updateRepository(int repoid,int size,Date date){
        UserRepository repo = userRepositoryMapper.getRepoById(repoid);
        repo.setSize(size);
        repo.setLastModifiedTime(date);
        userRepositoryMapper.updateRepo(repo);
    }
}
