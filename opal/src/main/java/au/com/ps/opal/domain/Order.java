package au.com.ps.opal.domain;

public class Order {

    private String oderId;
    private OpalCard card;

    public String getOderId() {
        return oderId;
    }

    public void setOderId(String oderId) {
        this.oderId = oderId;
    }

    public OpalCard getCard() {
        return card;
    }

    public void setCard(OpalCard card) {
        this.card = card;
    }


    @Override
    public String toString() {
        return "Order{" +
                "oderId='" + oderId + '\'' +
                ", card=" + card +
                '}';
    }
}
