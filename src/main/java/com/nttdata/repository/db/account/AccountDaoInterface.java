package com.nttdata.repository.db.account;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;

import java.util.List;
import java.util.Optional;

public interface AccountDaoInterface <Table>{
    List<Table> list();

    Optional<Table> getById(String id);

    Optional<Table> addNewAccount(CreateAccountDto accountRequest);
    void updateAccount(Table table);

}
