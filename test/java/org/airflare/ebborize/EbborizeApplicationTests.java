package org.airflare.ebborize;

import org.airflare.ebborize.pojo.Card;
import org.airflare.ebborize.pojo.UserRepository;
import org.airflare.ebborize.service.CardService;
import org.airflare.ebborize.service.UserRepositoryService;
import org.airflare.ebborize.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EbborizeApplicationTests {

    UserService userService;
    UserRepositoryService userRepositoryService;
    CardService cardService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepositoryService(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
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

    @Test
    void selectRepoByUserId(){
        int id = 10001;
        List<UserRepository> userRepositories = userRepositoryService.selectRepoByUserId(id);
        for (UserRepository userRepository : userRepositories) {
            System.out.println(userRepositories);
        }
    }

    @Test
    void selectExpiredCard(){
        List<Card> cards = cardService.selectExpiredCard(100001);
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    @Test
    void insertCard(){
        cardService.addCard(100001,"java","一门编程语言");
        cardService.addCard(100001,"JVM","java virtual machine");
        cardService.addCard(100001,"jdk","java development kit");
    }

}
