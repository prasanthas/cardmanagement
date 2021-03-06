package au.com.ps.opal.delegate.impl;

import au.com.ps.opal.delegate.PostageDelegate;
import au.com.ps.opal.domain.Customer;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PostageDelegateImpl implements PostageDelegate {

    final static Logger logger = LoggerFactory.getLogger(PostageDelegateImpl.class);

    @Override
    public String postCard(OpalCard opalCard, Customer customer) {

        //Call another service to Post

        String refNo = "p12345";
        return refNo;
    }

    @Override
    public String postCard(OpalCard opalCard, String customerId) {

        //Call another service to post
        logger.debug("Inside Post Card");

        String refNo = "p12346";
        return refNo;
    }
}
