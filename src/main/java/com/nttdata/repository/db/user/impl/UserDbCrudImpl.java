package com.nttdata.repository.db.user.impl;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserCrud;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository("userDb")
public class UserDbCrudImpl implements UserCrud {
    @Override
    public User insertNewUser(CreateUserDto userRequest, String idAccount) {
        return null;
    }

    @Override
    public User retrieveUserById(String id) {
        return null;
    }

    @Override
    public boolean updateUserNameById(String id, String name) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }

    @Override
    public String getAll() {
        return null;
    }
}
