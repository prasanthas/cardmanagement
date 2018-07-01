package au.com.ps.opal.domain;

public enum CardType {

    YOUTH("Youth"),
    ADULT("Adult"),
    PENSIONER("Pensioner"),
    SENIOR("Senior");

    private final String cardType;

    CardType(String type) {
        this.cardType = type;
    }

    public String getCardType() {
        return cardType;
    }

}
