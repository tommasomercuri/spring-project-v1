package com.nttdata.repository.db.user.impl;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository("userDb")
public class UserDbDaoImpl implements UserDao {
    @Override
    public User createNewUser(CreateUserDto userRequest, String idAccount) {
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
