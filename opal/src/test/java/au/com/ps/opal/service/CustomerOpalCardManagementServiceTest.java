package au.com.ps.opal.service;

import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


public class CustomerOpalCardManagementServiceTest {

//    public static final String SERVICE_URI = "http://localhost:8080/customers/";
    private static final String SERVICE_URI = "http://localhost:8080/customers/";


    @Test
    public void addCard() {

        System.out.println("Adding opalCar 1");
        OpalCard opalCard1 = OpalCardStub.getCard1();

        RestTemplate restTemplate = new RestTemplate();

        URI uri = restTemplate.postForLocation(SERVICE_URI+"1111/card/", opalCard1);

        System.out.println("Added URI: "+uri);

    }

    @Test
    public void testHelloWorld() {
        RestTemplate restTemplate = new RestTemplate();
        String hello = restTemplate.getForObject(SERVICE_URI+"22222/card/", String.class);
        System.out.println("Hellow: "+hello);
    }
}