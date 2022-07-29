package com.banking.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
@Data
@ToString
public class Account {

    public static final String SEQUENCE_NAME = "account_sequence";

    @Id
    private Long id;

    private int accountNumber;

    private String name;

    private String gender;

    private String dob;

    private String country;

    private double balance;

    private boolean validationStatus;

}
