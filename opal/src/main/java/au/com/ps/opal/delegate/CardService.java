package au.com.ps.opal.delegate;

import au.com.ps.opal.domain.OpalCard;
import org.springframework.stereotype.Service;

public interface CardService {

    OpalCard addCard(String customerId, OpalCard card);

    OpalCard getCard(String cardid);
}
