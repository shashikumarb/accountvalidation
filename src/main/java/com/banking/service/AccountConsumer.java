package com.banking.service;

import com.banking.dao.AccountDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.banking.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AccountConsumer {

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    SequenceGeneratorService seqGeneratorService;

    private ObjectMapper mapper = new ObjectMapper();
    Account account;

    @KafkaListener(topics = "accounts")
    public void listenWithHeaders(String content) {
        String padded = "";

        try {
            account = mapper.readValue(content, Account.class);
            int accountNumber = account.getAccountNumber();
            int length = countDig(accountNumber);
            if(length<10){
                padded = String.format("%010d" , accountNumber);
                System.out.println("Account Number padded with leading Zeros is :"+ padded);
            }
            account.setAccountNumber(Integer.parseInt(padded));
            account.setId(seqGeneratorService.generateSequence(Account.SEQUENCE_NAME));
            account.setValidationStatus(true);

            accountDAO.save(account);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //method to check number of digits in account number
    public static int countDig(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count = count + 1;
        }
        return count;
    }
}