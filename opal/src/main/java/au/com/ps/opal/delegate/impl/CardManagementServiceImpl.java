package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.dao.CardServiceDao;
import au.com.ps.opal.delegate.CardManagementService;
import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.delegate.PaymentService;
import au.com.ps.opal.delegate.PostageService;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    final static Logger logger = LoggerFactory.getLogger(CardManagementServiceImpl.class);

    private static final String ADD_CARD_SERVICE_URI = "http://localhost:8080/cards/";

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PostageService postageService;

    @Autowired
    private CardServiceDao cardServiceDao;

    @Override
    public Order orderCard(String customerId, OpalCard opalCard) {
        logger.debug("Inside Order Card");

        Order order = new Order();
        OpalCard card = addCard(opalCard);
        linkCard(customerId, card);

        // if Initial amout available
        if (BigDecimal.ZERO.compareTo(opalCard.getAmount()) == -1) {
            String paymentRefNo = paymentService.topUp(customerId, card.getCardNo(), opalCard.getAmount());
            order.setPaymentRefNo(paymentRefNo);
        }

        postageService.postCard(opalCard, customerId);

        card.setCardNo("C-1234");

        order.setOderId("O-12334");
        order.setCard(card);

        return order;
    }

    private void linkCard(String customerId, OpalCard card) {
        cardService.linkCard(customerId, card);
    }

    /**
     * Use OpalCardAPI to create a card
     * @param opalCard
     * @return
     */
    private OpalCard addCard(OpalCard opalCard) {
        return cardServiceDao.addCard(opalCard);
    }


}
