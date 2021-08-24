package org.airflare.ebborize;

import org.airflare.ebborize.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EbborizeApplicationTests {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void addUser(){
        String name = "bboygun";
        String pwd = "2c8034ba59512de280ba116b81f0b5b343a5df963fd2fc1cbcb3cd935ac9fe3e";
        userService.addUser(name,pwd);
    }

}
