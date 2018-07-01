package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardServiceImplTest {


    @Test
    public void shouldCreateCardAndReturnId() {
        CardService cardService = new CardServiceImpl();
        OpalCard card1 = OpalCardStub.getCard1();
        cardService.addCard("1232", card1);
    }
}