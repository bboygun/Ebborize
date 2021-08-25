package org.airflare.ebborize.mapper;

import org.airflare.ebborize.pojo.Card;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardMapper {
    List<Card> selectCardByRepoId(int repoId);
    int insertCard(Card card);
    int updateCard(Card card);
    List<Card> selectExpiredCard(@Param("repoId") int repoId,@Param("date") String date);
}
