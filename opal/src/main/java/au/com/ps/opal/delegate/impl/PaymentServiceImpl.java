package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentServiceImpl implements PaymentService {

    final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Override
    public String topUp(String customerId, String cardId, BigDecimal amount) {

        //Call another Service to

        logger.debug("Inside topUp");

        String receipt = "123";

        return receipt;
    }
}
