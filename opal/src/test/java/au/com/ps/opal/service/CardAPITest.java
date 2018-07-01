package au.com.ps.opal.service;

import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.stub.OpalCardStub;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.*;

public class CardAPITest {


    private static final String SERVICE_URI = "http://localhost:8080/cards/";

    @Test
    public void shouldReturnCard() {
        RestTemplate restTemplate = new RestTemplate();
        OpalCard card = restTemplate.getForObject(SERVICE_URI+"CA-12345", OpalCard.class);

        System.out.println("card: "+card);

    }

    @Test
    public void testAddCard() {
        System.out.println("Adding opalCar 1");
        OpalCard opalCard1 = OpalCardStub.getCard1();

        RestTemplate restTemplate = new RestTemplate();

        URI uri = restTemplate.postForLocation(SERVICE_URI, opalCard1);

        System.out.println("Added URI: "+uri);
    }

    @Test
    public void shouldUpdateCard() {
        OpalCard opalCard1 = OpalCardStub.getCard1();

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.put(SERVICE_URI+"CA-12345",opalCard1);

    }

    @Test
    public void shouldDeleteCard() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(SERVICE_URI+"CA-12345");

    }
}