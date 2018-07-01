package au.com.ps.opal.dao;

import java.math.BigDecimal;

public interface PaymentServiceDao {
    String topUp(String customerId, String cardId, BigDecimal amount);
}
