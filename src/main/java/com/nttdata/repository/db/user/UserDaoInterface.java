package com.nttdata.repository.db.user;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.user.CreateUserDto;

import java.util.List;
import java.util.Optional;

public interface UserDaoInterface <Table>{
    List<Table> list();
    Optional<Table> getById(String id);

    User addNewUser(CreateUserDto createUserDto);
    void updateAccount(Table table);
}
