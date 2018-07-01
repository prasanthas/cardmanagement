package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.dao.CardServiceDao;
import au.com.ps.opal.delegate.CardManagementService;
import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.delegate.PaymentService;
import au.com.ps.opal.delegate.PostageService;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CardManagementServiceImplTest {

    @Mock
    private CardService cardService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private PostageService postageService;

    @Mock
    private CardServiceDao cardServiceDao;

    @InjectMocks
    private CardManagementServiceImpl cardManagementService;

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
        verify(paymentService, times(0)).topUp(isA(String.class), isA(String.class), isA(BigDecimal.class));
        verify(postageService).postCard(isA(OpalCard.class), isA(String.class));
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
        verify(paymentService).topUp(isA(String.class), isA(String.class), isA(BigDecimal.class));
        verify(postageService).postCard(isA(OpalCard.class), isA(String.class));
        verify(cardServiceDao).addCard(isA(OpalCard.class));
        System.out.println(order);

    }

}