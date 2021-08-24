package org.airflare.ebborize.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
    private int repositoryId;
    private String repositoryName;
    private int userId;
    private Date createTime;
    private Date lastModifiedTime;
}
