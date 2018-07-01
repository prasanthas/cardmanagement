package au.com.ps.opal.domain;

import java.math.BigDecimal;

public class OpalCard {

    private String cardNo;

    private CardType cardType;
    private BigDecimal amount;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OpalCard{" +
                "cardNo='" + cardNo + '\'' +
                ", cardType=" + cardType +
                ", amount=" + amount +
                '}';
    }
}
