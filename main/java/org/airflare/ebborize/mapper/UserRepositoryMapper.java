package org.airflare.ebborize.mapper;

import org.airflare.ebborize.pojo.UserRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryMapper {

    List<UserRepository> getRepoByUserId(@Param("id") int userid);

    UserRepository getRepoById(int id);

    int insertRepo(UserRepository repo);

    void updateRepo(UserRepository repo);
}
