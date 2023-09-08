package com.nttdata.services.repository;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;

public interface AccountQueryService {
    Account createNewAccount(CreateAccountDto accountRequest);
    Account retrieveAccountById(String id);
    boolean updateAccount(Account account);
    boolean updateAccountEmailById(String id);
    boolean updateAccountPasswordById(String id);
    boolean deleteAccount(String id);


}
