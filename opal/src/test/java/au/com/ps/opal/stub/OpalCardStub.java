package au.com.ps.opal.stub;

import au.com.ps.opal.domain.CardType;
import au.com.ps.opal.domain.OpalCard;

import java.math.BigDecimal;

public class OpalCardStub {


    public static OpalCard getCard(String cardNo, CardType cardType, BigDecimal amount) {
        OpalCard opalCard = new OpalCard();
        opalCard.setCardNo(cardNo);
        opalCard.setCardType(cardType);
        opalCard.setAmount(amount);

        return opalCard;
    }

    public static OpalCard getCard1() {
        return getCard("1111", CardType.ADULT, BigDecimal.valueOf(25));
    }

    public static OpalCard getCard2() {
        return getCard("2222", CardType.SENIOR, BigDecimal.valueOf(0));
    }

}
