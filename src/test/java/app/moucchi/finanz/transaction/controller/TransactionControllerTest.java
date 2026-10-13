package app.moucchi.finanz.transaction.controller;

import app.moucchi.finanz.transaction.businessObject.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class TransactionControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName(" should return `ok` when the transaction exists, the response body should contain the requested transaction")
    void getTransactionById_success() {
        //Given the following transaction exists in the database
        Transaction expectedTransaction = Transaction.builder()
                .id("1")
                .dateTime("2023-03-15T10:15:30Z")
                .title("Title 1")
                .description("Description 1")
                .amount(BigDecimal.valueOf(100))
                .build();

        //When a call to "/transactions/1" is made
        ResponseEntity<Transaction> response = restTemplate.getForEntity("/transactions/1", Transaction.class);

        //Then the response should be `ok` and the body should contain the requested transaction
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()),
                () -> assertEquals(expectedTransaction, response.getBody())
        );
    }

    @Test
    @DisplayName(" should return a `not found` code when the requested transaction does not exist")
    void getTransactionById_notFound() {
        //TODO
    }

}