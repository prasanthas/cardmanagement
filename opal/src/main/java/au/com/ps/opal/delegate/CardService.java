package au.com.ps.opal.delegate;

import au.com.ps.opal.domain.OpalCard;
import org.springframework.stereotype.Service;

public interface CardService {

    OpalCard linkCard(String customerId, OpalCard card);

    OpalCard addCard(OpalCard card);

    OpalCard getCard(String cardId);

    OpalCard updateCard(OpalCard card);

    void deleteCard(String cardId);

}
