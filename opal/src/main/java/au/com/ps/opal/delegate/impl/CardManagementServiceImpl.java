package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.CardManagementService;
import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    @Autowired
    private CardService cardService;


    @Override
    public Order orderCard(String customerId, OpalCard opalCard) {

        OpalCard card = cardService.addCard(customerId, opalCard);

        OpalCard opalCard1 = new OpalCard();
        opalCard1.setCardNo("C-1234");

        Order order = new Order();
        order.setOderId("O-12334");
        order.setCard(opalCard1);


        return order;
    }
}
