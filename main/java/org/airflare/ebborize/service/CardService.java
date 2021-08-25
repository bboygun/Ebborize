package org.airflare.ebborize.service;

import org.airflare.ebborize.mapper.CardMapper;
import org.airflare.ebborize.pojo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CardService {

    private CardMapper mapper;

    @Autowired
    public void setMapper(CardMapper mapper) {
        this.mapper = mapper;
    }

    public int addCard(int repoId,String key,String value){
        Card card = new Card();
        card.setCardKey(key);
        card.setCardValue(value);
        card.setRepositoryId(repoId);
        Date createDate = new Date();
        card.setLastTime(createDate);
        card.setNextTime(createDate);
        mapper.insertCard(card);
        return card.getCardId();
    }

    public List<Card> selectCardByRepoId(int repoId){
        return mapper.selectCardByRepoId(repoId);
    }

    public List<Card> selectExpiredCard(int repoId){
        String formDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        List<Card> cards = mapper.selectExpiredCard(repoId, formDate);
        return cards;
    }
}
