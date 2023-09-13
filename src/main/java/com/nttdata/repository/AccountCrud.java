package com.nttdata.repository;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;

public interface AccountCrud {
    Account insertNewAccount(CreateAccountDto accountRequest);
    Account retrieveAccountById(String id);
    boolean updateAccountEmailById(String id, String email);
    boolean updateAccountPasswordById(String id, String password);
    boolean deleteAccountById(String id);
    String getAll();
    public boolean checkIfAccountExistById(String id);


}
