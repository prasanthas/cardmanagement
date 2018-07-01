package au.com.ps.opal.domain;

public class Order {

    private String oderId;
    private OpalCard card;
    private String paymentRefNo;
    private String postageRefNo;

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

    public String getPaymentRefNo() {
        return paymentRefNo;
    }

    public void setPaymentRefNo(String paymentRefNo) {
        this.paymentRefNo = paymentRefNo;
    }

    public String getPostageRefNo() {
        return postageRefNo;
    }

    public void setPostageRefNo(String postageRefNo) {
        this.postageRefNo = postageRefNo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oderId='" + oderId + '\'' +
                ", card=" + card +
                ", paymentRefNo='" + paymentRefNo + '\'' +
                ", postageRefNo='" + postageRefNo + '\'' +
                '}';
    }
}
