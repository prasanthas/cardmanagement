package au.com.ps.opal.service;

import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import au.com.ps.opal.domain.Order;
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
@RequestMapping("/cards/")
public class OpalCardAPI {

    final static Logger logger = LoggerFactory.getLogger(OpalCardAPI.class);

    @Autowired
    private CardService cardService;

    @GetMapping("{cardId}")
    public ResponseEntity<OpalCard> getCard(@PathVariable("cardId") String cardId) {
        logger.debug("Inside getCard cardId: " + cardId);

        OpalCard card = cardService.getCard(cardId);

        if(card == null) {
            logger.debug("Card Not Found");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        logger.debug("Opal Card ID: "+card.getCardNo());
        return new ResponseEntity<OpalCard>(card, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<?> addCard(@RequestBody OpalCard opalCard, UriComponentsBuilder ucBuilder) {
        logger.debug("Add Card");

        OpalCard card = cardService.addCard(opalCard);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("cards/"+card.getCardNo()).buildAndExpand(card.getCardNo()).toUri());

        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    @PutMapping("{cardId}")
    ResponseEntity<?> updateCard(@PathVariable("cardId") String cardId, @RequestBody OpalCard opalCard, UriComponentsBuilder ucBuilder) {
        logger.debug("Update Card");

        OpalCard card1 = cardService.getCard(cardId);

        if (card1 == null) {
            return new ResponseEntity("Card Not Found", HttpStatus.NOT_FOUND);
        }
        OpalCard card = cardService.addCard(opalCard);
        return new ResponseEntity<OpalCard>(card, HttpStatus.OK);
    }

    @DeleteMapping("{cardId}")
    ResponseEntity<?> deleteCard(@PathVariable("cardId") String cardId, UriComponentsBuilder ucBuilder) {
        logger.debug("Update Card");

        OpalCard card1 = cardService.getCard(cardId);

        if (card1 == null) {
            return new ResponseEntity("Card Not Found", HttpStatus.NOT_FOUND);
        }
       cardService.deleteCard(cardId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
