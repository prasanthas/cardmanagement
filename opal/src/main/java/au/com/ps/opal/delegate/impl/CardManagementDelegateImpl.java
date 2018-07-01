package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.dao.CardServiceDao;
import au.com.ps.opal.delegate.CardManagementDelegate;
import au.com.ps.opal.delegate.CardDelegate;
import au.com.ps.opal.delegate.PaymentDelegate;
import au.com.ps.opal.delegate.PostageDelegate;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardManagementDelegateImpl implements CardManagementDelegate {

    final static Logger logger = LoggerFactory.getLogger(CardManagementDelegateImpl.class);

    private static final String ADD_CARD_SERVICE_URI = "http://localhost:8080/cards/";

    @Autowired
    private CardDelegate cardDelegate;

    @Autowired
    private PaymentDelegate paymentDelegate;

    @Autowired
    private PostageDelegate postageDelegate;

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
            String paymentRefNo = paymentDelegate.topUp(customerId, card.getCardNo(), opalCard.getAmount());
            order.setPaymentRefNo(paymentRefNo);
        }

        postageDelegate.postCard(opalCard, customerId);

        order.setOderId("O-12334");
        order.setCard(card);

        return order;
    }

    private void linkCard(String customerId, OpalCard card) {
        cardDelegate.linkCard(customerId, card);
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
