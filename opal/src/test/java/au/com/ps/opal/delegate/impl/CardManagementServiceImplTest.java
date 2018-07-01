package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.CardManagementService;
import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.smartcardio.Card;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;



//@RunWith(MockitoJUnitRunner.class)
@Ignore
public class CardManagementServiceImplTest {

    @Mock
    private CardService cardService;

    @InjectMocks
    private CardManagementServiceImpl cardManagementService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnOrder() {
        OpalCard card1 = OpalCardStub.getCard1();
        OpalCard card2 = OpalCardStub.getCard1();
        card2.setCardNo(card1.getCardNo());

        String customerId = "CC-1111";
        when(cardService.addCard(customerId, card1)).thenReturn(card2);

        cardManagementService = new CardManagementServiceImpl();
        Order order = cardManagementService.orderCard(customerId, card1);

        System.out.println(order);

    }
}