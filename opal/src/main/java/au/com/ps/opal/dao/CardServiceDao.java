package au.com.ps.opal.dao;

import au.com.ps.opal.domain.OpalCard;

public interface CardServiceDao {

    OpalCard linkCard(String customerId, OpalCard card);

    OpalCard addCard(OpalCard card);

    OpalCard getCard(String cardId);

    OpalCard updateCard(OpalCard card);

    void deleteCard(String cardId);

    void storeCard(OpalCard card);
}
