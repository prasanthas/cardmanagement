package au.com.ps.opal.service;

import au.com.ps.opal.delegate.CardService;
import au.com.ps.opal.domain.OpalCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /*@GetMapping("{cardId}")
    public String getHelloWorld(@PathVariable("cardId") String cardId) {
        System.out.println("IIII: "+cardId);
        logger.debug("IDIDIDI: "+ cardId);
        return "Hellow World CardAPI Prasantha"+cardId;
    }*/


}
