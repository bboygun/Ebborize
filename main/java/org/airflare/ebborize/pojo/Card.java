package org.airflare.ebborize.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int cardId;
    private int repositoryId;
    private String cardKey;
    private String cardValue;
    private int level;
    private Date lastTime;
    private Date nextTime;
}
