package com.nttdata.repository.db.account;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.account.UpdateAccountEmailByIdDto;
import com.nttdata.model.dto.account.UpdateAccountPasswordByIdDto;

import java.util.List;
import java.util.Optional;

public interface AccountDaoInterface <Table>{
    List<Table> list();

    Optional<Table> getById(String id);

    void updateAccountEmailById(String email, String id);
    void updateAccountPasswordById(String password, String id);
    void deleteAccountById(String id);

}
