package app.moucchi.finanz.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class TransactionControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName(" `getTransactionById` should return `ok` when the transaction exists, the response body should contain the requested transaction")
    void getTransactionById_success() {
        //TODO
    }

    @Test
    @DisplayName(" `getTransactionById` should return a `not found` code when the requested transaction does not exist")
    void getTransactionById_notFound() {
        //TODO
    }

}