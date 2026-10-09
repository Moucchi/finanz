package app.moucchi.finanz.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class transactionController {

    @GetMapping("/transactions/{transactionId}")
    public ResponseEntity<String> getTransactionById(@PathVariable("transactionId") String id) {
        try {
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error has occurred while processing the request, please try again later.");
        }
    }
}
