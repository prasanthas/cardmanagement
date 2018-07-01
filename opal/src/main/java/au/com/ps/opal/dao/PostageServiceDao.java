package au.com.ps.opal.dao;

import au.com.ps.opal.domain.Customer;
import au.com.ps.opal.domain.OpalCard;

public interface PostageServiceDao {
    String postCard(OpalCard opalCard, Customer customer);
    String postCard(OpalCard opalCard, String customerId);

}
