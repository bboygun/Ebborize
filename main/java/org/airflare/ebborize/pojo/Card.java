package org.airflare.ebborize.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private int cardId;
    private int repositoryId;
    private String cardKey;
    private String cardValue;
}
