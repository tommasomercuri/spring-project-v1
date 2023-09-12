package com.nttdata.repository.db.account.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.repository.AccountQueryService;
import com.nttdata.service.uuid.UuidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Slf4j
@Repository("accountDb")
public class AccountDbQueryServiceImpl implements AccountQueryService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UuidService uuidService;

    @Override
    public Account createNewAccount(CreateAccountDto accountRequest) {
        String id = uuidService.createNewUuid();
        String query = "INSERT INTO Account (idAccount,email,password,createdAtDate) VALUES (?,?,?,CURRENT_TIME());";
        jdbcTemplate.update(query, id, accountRequest.getEmail(),accountRequest.getPassword());
        Date date = new Date();
        Account account = new Account( id, accountRequest.getEmail(), accountRequest.getPassword(), date);
        return account;
    }

    @Override
    public Account retrieveAccountById(String id) {
        return null;
    }

    @Override
    public boolean updateAccountEmailById(String id, String email) {
        return false;
    }

    @Override
    public boolean updateAccountPasswordById(String id, String password) {
        return false;
    }

    @Override
    public boolean deleteAccountById(String id) {
        return false;
    }

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public boolean checkIfAccountExistById(String id) {
        return false;
    }
}
