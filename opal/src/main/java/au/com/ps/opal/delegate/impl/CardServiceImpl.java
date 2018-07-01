package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.CardType;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardServiceImpl implements CardService {

    final static Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    @Override
    public OpalCard addCard(String customerId, OpalCard card) {
        logger.debug("Inside addCard Service");

        //Call another API to create Card
        card.setCardNo("1234");

        return card;
    }

    @Override
    public OpalCard getCard(String cardId) {
        logger.debug("Inside getCard CardId: " + cardId);

        OpalCard opalCard = new OpalCard();
        opalCard.setCardNo(cardId);
        opalCard.setAmount(new BigDecimal(100));
        opalCard.setCardType(CardType.ADULT);

        logger.debug("returning Opal Card id: " + opalCard.getCardNo());

        return opalCard;
    }
}
