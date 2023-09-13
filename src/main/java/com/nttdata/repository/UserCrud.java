package com.nttdata.repository;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;

public interface UserCrud {
    User insertNewUser(CreateUserDto userRequest, String idAccount);
    User retrieveUserById(String id);
    boolean updateUserNameById(String id, String name);
    boolean deleteUser(String id);
    String getAll();

}
