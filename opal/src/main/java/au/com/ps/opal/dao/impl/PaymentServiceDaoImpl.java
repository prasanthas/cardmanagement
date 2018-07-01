package au.com.ps.opal.dao.impl;

import au.com.ps.opal.dao.PaymentServiceDao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentServiceDaoImpl implements PaymentServiceDao {
    @Override
    public String topUp(String customerId, String cardId, BigDecimal amount) {
        return null;
    }
}
