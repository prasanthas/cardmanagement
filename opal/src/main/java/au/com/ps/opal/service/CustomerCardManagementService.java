package au.com.ps.opal.service;

import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/customers/{customerId}/card")
public class CustomerCardManagementService {

    final static Logger logger = LoggerFactory.getLogger(CustomerCardManagementService.class);


    @Autowired
    private CardService cardService;

    @GetMapping
    public String getHelloWorld() {
        return "Hellow World Prasantha";
    }

    /**
     * Add opalCard
     * If initial top up is there then top up. Payment
     *
     */

    @PostMapping
    ResponseEntity<?> addCard(@PathVariable("customerId") String customerId, @RequestBody OpalCard opalCard, UriComponentsBuilder ucBuilder) {
        logger.info("Add OpalCard",customerId);
        logger.info("opalCard: ",opalCard);

        System.out.println("calling cardService");
        OpalCard card = cardService.addCard(customerId, opalCard);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("customers/"+customerId+"/card/{id}").buildAndExpand(card.getCardNo()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

}
