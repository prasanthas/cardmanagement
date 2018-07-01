package au.com.ps.opal.delegate;

import au.com.ps.opal.domain.Customer;
import au.com.ps.opal.domain.OpalCard;

public interface PostageService {

    String postCard(OpalCard opalCard, Customer customer);
}
