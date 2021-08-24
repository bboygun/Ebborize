package org.airflare.ebborize.mapper;

import org.airflare.ebborize.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    void addUser(User user);
    User getUserByName(String name);
    User getUserByNameAndPassword(@Param("name")String Name, @Param("password") String password);
}
