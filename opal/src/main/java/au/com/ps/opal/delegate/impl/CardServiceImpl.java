package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
}
