package com.nttdata.repository.db.user.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserCrud;
import com.nttdata.repository.db.account.AccountDaoInterface;
import com.nttdata.repository.db.account.AccountDetails;
import com.nttdata.repository.db.user.UserDaoInterface;
import com.nttdata.repository.db.user.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository("userDb")
public class UserDbCrudImpl implements UserCrud {

    @Autowired
    UserJdbcDao userJdbcDao;

    private static UserDaoInterface<UserDetails> usrDao;

    public UserDbCrudImpl(UserDaoInterface<UserDetails> usrDao){
        this.usrDao = usrDao;
    }


    @Override
    public User insertNewUser(CreateUserDto userRequest) {
        return userJdbcDao.addNewUser(userRequest);
    }

    @Override
    public User retrieveUserById(String id) {
        Optional<UserDetails> user = usrDao.getById(id);
        UserDetails usr = user.get();
        return new User(usr.getIdUser(),usr.getUsername(),String.valueOf(usr.getBornYear()), usr.getIdAccount());
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
