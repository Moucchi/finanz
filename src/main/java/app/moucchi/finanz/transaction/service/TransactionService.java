package app.moucchi.finanz.transaction.service;

import app.moucchi.finanz.transaction.businessObject.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class TransactionService {

    public Transaction getTransactionById(String id) {
        HashMap<String, Transaction> transactions = new HashMap<>();
        transactions.put("1", new Transaction("1", "2023-03-15T10:15:30Z", "Title 1", "Description 1", BigDecimal.valueOf(100)));
        transactions.put("2", new Transaction("2", "2023-03-16T11:20:45Z", "Title 2", "Description 2", BigDecimal.valueOf(200.54)));

        try {
            return transactions.getOrDefault(id, null);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while retrieving the transaction.", e);
        }
    }
}
