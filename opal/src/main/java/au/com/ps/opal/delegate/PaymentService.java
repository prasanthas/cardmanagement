package au.com.ps.opal.delegate;

import java.math.BigDecimal;

public interface PaymentService {

    String topUp(String customerId, String cardId, BigDecimal amount);
}
