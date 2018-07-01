package au.com.ps.opal.delegate;

import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;

public interface CardManagementDelegate {

    Order orderCard(String customerId, OpalCard opalCard);

}
