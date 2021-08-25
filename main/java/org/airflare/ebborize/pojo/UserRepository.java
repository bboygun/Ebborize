package org.airflare.ebborize.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRepository {
    private int repositoryId;
    private String repositoryName;
    private int userId;
    private Date createTime;
    private Date lastModifiedTime;
    private int size;
}
