package com.nttdata.services.repository.map.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.services.repository.AccountQueryService;
import com.nttdata.services.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@Component
@Data
@NoArgsConstructor
public class AccountMapQueryServiceImpl implements AccountQueryService {
    @Autowired
    UuidService uuidService;
    @Override
    public Account createNewAccount(CreateAccountDto accountRequest) {
        Date date = new Date();
        Account account = new Account( uuidService.createNewUuid(), accountRequest.getEmail(), accountRequest.getPassword(), date);
        System.out.println("Created new account:" + account.toString());
        return account;
    }

    @Override
    public Account retrieveAccountById(String id) {
        return null;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }
    @Override
    public boolean updateAccountEmailById(String id) {
        return false;
    }
    @Override
    public boolean updateAccountPasswordById(String id) {
        return false;
    }
    @Override
    public boolean deleteAccount(String id) {
        return false;
    }




}
