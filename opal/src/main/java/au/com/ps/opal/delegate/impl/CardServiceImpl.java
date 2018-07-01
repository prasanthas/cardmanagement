package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.dao.CardServiceDao;
import au.com.ps.opal.dao.PaymentServiceDao;
import au.com.ps.opal.dao.PostageServiceDao;
import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.CardType;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardServiceImpl implements CardService {

    final static Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CardServiceDao cardServiceDao;

    @Autowired
    private PaymentServiceDao paymentServiceDao;

    @Autowired
    private PostageServiceDao postageServiceDao;

    @Override
    public OpalCard addCard(String customerId, OpalCard card) {
        logger.debug("Inside addCard Service");

        //Call another API to create Card
       cardServiceDao.addCard(card);

        return card;
//        return car;
    }

    @Override
    public OpalCard getCard(String cardId) {
        logger.debug("Inside getCard CardId: " + cardId);

        OpalCard card = cardServiceDao.getCard(cardId);

        logger.debug("returning Opal Card id: " + card.getCardNo());

        return card;
    }

    @Override
    public OpalCard updateCard(OpalCard card) {
        logger.debug("Inside getCard CardId: " + card.getCardNo());

        OpalCard opalCard = new OpalCard();
        opalCard.setAmount(new BigDecimal(200));
        opalCard.setCardType(CardType.YOUTH);

        logger.debug("returning Opal Card id: " + opalCard.getCardNo());

        return opalCard;
    }

    @Override
    public void deleteCard(String cardId) {

        //Call the serice to delete
        //throw Exception if it is not successfull

    }

    @Override
    public OpalCard addCard(OpalCard card) {
        logger.debug("Inside addCard Service");

        //Call another API to create Card
        card.setCardNo("5555");

        return card;
    }
}
