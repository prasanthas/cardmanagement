package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.PaymentService;

import java.math.BigDecimal;

public class PaymentServiceImpl implements PaymentService {


    @Override
    public String topUp(String customerId, String cardId, BigDecimal amount) {

        //Call another Service to


        String receipt = "123";

        return receipt;
    }
}
