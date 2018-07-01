package au.com.ps.opal.delegate.impl;

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

import java.math.BigDecimal;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    final static Logger logger = LoggerFactory.getLogger(CardManagementServiceImpl.class);

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PostageService postageService;

    @Override
    public Order orderCard(String customerId, OpalCard opalCard) {
        logger.debug("Inside Order Card");


        Order order = new Order();

        OpalCard card = cardService.addCard(customerId, opalCard);

        // if Initial amout available
        if (BigDecimal.ZERO.compareTo(opalCard.getAmount()) == -1) {
            String paymentRefNo = paymentService.topUp(customerId, card.getCardNo(), opalCard.getAmount());
            order.setPaymentRefNo(paymentRefNo);
        }

        postageService.postCard(opalCard, customerId);

        OpalCard opalCard1 = new OpalCard();
        opalCard1.setCardNo("C-1234");

        order.setOderId("O-12334");
        order.setCard(opalCard1);

        return order;
    }
}
