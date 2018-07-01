package au.com.ps.opal.delegate;

import java.math.BigDecimal;

public interface PaymentDelegate {

    String topUp(String customerId, String cardId, BigDecimal amount);
}
