package app.moucchi.finanz.transaction.businessObject;

import lombok.*;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Transaction {
    private String id;
    private Instant date;
    private String title;
    private String description;
    private BigDecimal amount;

    @Builder
    public Transaction(String id, String dateTime, String title, String description, BigDecimal amount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amount = amount;

        try {
            this.date = Instant.parse(dateTime);

        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid date format. Please use the ISO-8601 format (e.g., 2023-03-15T10:15:30Z).", dateTime, e.getErrorIndex());
        }
    }
}