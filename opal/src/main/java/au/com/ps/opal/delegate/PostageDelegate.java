package au.com.ps.opal.delegate;

import au.com.ps.opal.domain.Customer;
import au.com.ps.opal.domain.OpalCard;

public interface PostageDelegate {

    String postCard(OpalCard opalCard, Customer customer);
    String postCard(OpalCard opalCard, String customerId);
}
