package com.nttdata.repository.db.account.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.repository.AccountCrud;
import com.nttdata.repository.db.account.AccountDaoInterface;
import com.nttdata.repository.db.account.AccountDetails;
import com.nttdata.service.uuid.UuidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository("accountDb")
public class AccountDbCrudImpl implements AccountCrud {

    private static AccountDaoInterface<AccountDetails> accDao;

    public AccountDbCrudImpl(AccountDaoInterface<AccountDetails> accDao){
        this.accDao = accDao;
    }


    @Override
    public Account insertNewAccount(CreateAccountDto accountRequest) {
        Optional<AccountDetails> account = accDao.addNewAccount(accountRequest);
        AccountDetails acc = account.get();
        return new Account(acc.getIdAccount(),acc.getEmail(),acc.getPassword(),acc.getCreatedAtDate());

    }

    @Override
    public Account retrieveAccountById(String id) {
        Optional<AccountDetails> account = accDao.getById(id);
        AccountDetails acc = account.get();
        return new Account(acc.getIdAccount(),acc.getEmail(),acc.getPassword(),acc.getCreatedAtDate());
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
        List<AccountDetails> accounts = accDao.list();
        return accounts.toString();
    }

    @Override
    public boolean checkIfAccountExistById(String id) {
        return false;
    }
}
