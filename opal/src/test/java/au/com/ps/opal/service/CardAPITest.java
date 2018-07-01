package au.com.ps.opal.service;

import au.com.ps.opal.domain.OpalCard;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class CardAPITest {


    private static final String SERVICE_URI = "http://localhost:8080/cards/";

    @Test
    public void testGetCard() {
        RestTemplate restTemplate = new RestTemplate();
        OpalCard card = restTemplate.getForObject(SERVICE_URI+"CA-12345", OpalCard.class);

        System.out.println("card: "+card);

    }

    @Test
    public void testHelloWorld() {
        RestTemplate restTemplate = new RestTemplate();
        String hello = restTemplate.getForObject(SERVICE_URI+"22222/", String.class);
        System.out.println("Hellow: "+hello);
    }
}