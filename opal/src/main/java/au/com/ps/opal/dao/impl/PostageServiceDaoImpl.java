package au.com.ps.opal.dao.impl;

import au.com.ps.opal.dao.PostageServiceDao;
import au.com.ps.opal.domain.Customer;
import au.com.ps.opal.domain.OpalCard;
import org.springframework.stereotype.Service;

@Service
public class PostageServiceDaoImpl implements PostageServiceDao {
    @Override
    public String postCard(OpalCard opalCard, Customer customer) {
        return null;
    }

    @Override
    public String postCard(OpalCard opalCard, String customerId) {
        return null;
    }
}
