package au.com.ps.opal.service;

import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


public class CustomerOpalCardManagementDelegateTest {
    private static final String SERVICE_URI = "http://localhost:8080/customers/";

    @Test
    public void addCard() {
        System.out.println("Adding opalCar 1");
        OpalCard opalCard1 = OpalCardStub.getCard1();

        RestTemplate restTemplate = new RestTemplate();
        URI uri = restTemplate.postForLocation(SERVICE_URI+"1111/card/", opalCard1);

        System.out.println("Added URI: "+uri);
    }
}