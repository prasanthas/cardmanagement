package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.dao.CardServiceDao;
import au.com.ps.opal.delegate.CardDelegate;
import au.com.ps.opal.delegate.PaymentDelegate;
import au.com.ps.opal.delegate.PostageDelegate;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CardManagementDelegateImplTest {

    @Mock
    private CardDelegate cardDelegate;

    @Mock
    private PaymentDelegate paymentDelegate;

    @Mock
    private PostageDelegate postageDelegate;

    @Mock
    private CardServiceDao cardServiceDao;

    @InjectMocks
    private CardManagementDelegateImpl cardManagementService;

    @Test
    public void shouldReturnOrder() {
        OpalCard card1 = OpalCardStub.getCard1();
        OpalCard card2 = OpalCardStub.getCard1();
        card2.setCardNo(card1.getCardNo());

        String customerId = "CC-1111";
        card1.setAmount(BigDecimal.ZERO);
        when(cardServiceDao.addCard(card1)).thenReturn(card2);

        Order order = cardManagementService.orderCard(customerId, card1);

        Assert.assertEquals("O-12334", order.getOderId());
        verify(paymentDelegate, times(0)).topUp(isA(String.class), isA(String.class), isA(BigDecimal.class));
        verify(postageDelegate).postCard(isA(OpalCard.class), isA(String.class));
        verify(cardServiceDao).addCard(isA(OpalCard.class));
        System.out.println(order);

    }

    @Test
    public void shouldTopUpWhenAmountIsMoreThanZero() {
        OpalCard card1 = OpalCardStub.getCard1();
        OpalCard card2 = OpalCardStub.getCard1();
        card2.setCardNo(card1.getCardNo());

        String customerId = "CC-1111";
        when(cardServiceDao.addCard(card1)).thenReturn(card2);

        Order order = cardManagementService.orderCard(customerId, card1);

        Assert.assertEquals("O-12334", order.getOderId());
        verify(paymentDelegate).topUp(isA(String.class), isA(String.class), isA(BigDecimal.class));
        verify(postageDelegate).postCard(isA(OpalCard.class), isA(String.class));
        verify(cardServiceDao).addCard(isA(OpalCard.class));
        System.out.println(order);

    }

}