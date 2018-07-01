package au.com.ps.opal.delegate;

import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;

public interface CardManagementService {

    Order orderCard(String customerId, OpalCard opalCard);

}
