package au.com.ps.opal.dao.impl;

import au.com.ps.opal.dao.CardServiceDao;
import au.com.ps.opal.delegate.impl.CardManagementServiceImpl;
import au.com.ps.opal.domain.CardType;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class CardServiceDaoImpl implements CardServiceDao {
    final static Logger logger = LoggerFactory.getLogger(CardServiceDaoImpl.class);
    private static final String ADD_CARD_SERVICE_URI = "http://localhost:8080/cards/";

    @Autowired CardRepository cardRepository;

    @Override
    public OpalCard linkCard(String customerId, OpalCard card) {
        card.setCardNo("1234");
        // LINK Customer to Card

        return card;
    }

    @Override
    public OpalCard addCard(OpalCard opalCard) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = restTemplate.postForLocation(ADD_CARD_SERVICE_URI, opalCard);
        logger.debug("Added URI: "+uri);
        OpalCard card = restTemplate.getForObject(ADD_CARD_SERVICE_URI+opalCard.getCardNo(), OpalCard.class);

        logger.debug("card Id: "+card.getCardNo());

        storeCard(card);

        return card;

    }

    public void storeCard(OpalCard card) {
        cardRepository.save(card);
    }

    @Override
    public OpalCard getCard(String cardId) {
        OpalCard opalCard = new OpalCard();
        opalCard.setCardNo(cardId);
        opalCard.setAmount(new BigDecimal(100));
        opalCard.setCardType(CardType.ADULT);

        return opalCard;
    }

    @Override
    public OpalCard updateCard(OpalCard card) {

        OpalCard opalCard = new OpalCard();
        opalCard.setAmount(new BigDecimal(200));
        opalCard.setCardType(CardType.YOUTH);

        return opalCard;
    }

    @Override
    public void deleteCard(String cardId) {

    }
}
