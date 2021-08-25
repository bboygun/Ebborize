package org.airflare.ebborize.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String password;
    private String salt;
    private Date regisTime;
    private UserRepository[] repositories;
}
