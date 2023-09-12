package com.nttdata.repository.map.account.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.repository.map.account.AccountMapRepo;
import com.nttdata.repository.AccountQueryService;
import com.nttdata.services.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@Component
@Data
@NoArgsConstructor
public class AccountMapQueryServiceImpl implements AccountQueryService {
    @Autowired
    AccountMapRepo accountMap;

    @Autowired
    UuidService uuidService;

    @Override
    public Account createNewAccount(CreateAccountDto accountRequest) {
        Date date = new Date();
        String id = uuidService.createNewUuid();
        Account account = new Account( id, accountRequest.getEmail(), accountRequest.getPassword(), date);
        accountMap.getMap().put(id, account);
        return account;
    }

    @Override
    public String getAll() {
        return accountMap.getMap().toString();  //!!!!!!!! DA RENDERE MAP
    }

    @Override
    public Account retrieveAccountById(String id) {
        return accountMap.getMap().get(id);
    }

    @Override
    public boolean updateAccountEmailById(String id, String email) {
        accountMap.getMap().get(id).setEmail(email);
        return true;
    }
    @Override
    public boolean updateAccountPasswordById(String id, String password) {
        accountMap.getMap().get(id).setPassword(password);
        return true;
    }
    @Override
    public boolean deleteAccountById(String id) {
        accountMap.getMap().remove(id);
        return true;
    }

    public boolean checkIfAccountExistById(String id) {
            return accountMap.getMap().containsKey(id);
    }

}
