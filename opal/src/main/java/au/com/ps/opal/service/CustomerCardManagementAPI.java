package au.com.ps.opal.service;

import au.com.ps.opal.delegate.CardManagementDelegate;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/customers/{customerId}/card")
public class CustomerCardManagementAPI {

    final static Logger logger = LoggerFactory.getLogger(CustomerCardManagementAPI.class);

    @Autowired
    private CardManagementDelegate cardManagementDelegate;

    @PostMapping
    ResponseEntity<?> addCard(@PathVariable("customerId") String customerId, @RequestBody OpalCard opalCard, UriComponentsBuilder ucBuilder) {
        logger.debug("Add OpalCard",customerId);
        logger.debug("opalCard: ",opalCard);

        Order order = cardManagementDelegate.orderCard(customerId, opalCard);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("customers/"+customerId+"/card/{id}").buildAndExpand(order.getCard().getCardNo()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

}
