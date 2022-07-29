package com.banking.dao;

import com.banking.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends MongoRepository<Account, Long> {
}
