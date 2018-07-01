package au.com.ps.opal.stub;

import au.com.ps.opal.domain.Order;

public class OderStub {


    public static Order getOrder1() {
        Order order = new Order();

        order.setOderId("O-1234");
        order.setCard(OpalCardStub.getCard1());

        return order;
    }


}
