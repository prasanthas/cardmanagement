package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.PostageService;
import au.com.ps.opal.domain.Customer;
import au.com.ps.opal.domain.OpalCard;

public class PostageServiceImpl implements PostageService {

    @Override
    public String postCard(OpalCard opalCard, Customer customer) {

        //Call another service to Post

        String refNo = "p12345";
        return refNo;
    }
}
