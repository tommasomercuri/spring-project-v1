package com.nttdata.services.repository;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;

public interface UserQueryService {
    User createNewUser(CreateUserDto userRequest);
    User retrieveUserById(String id);
    boolean updateUser(User user);
    boolean updateAccountEmail(Account account);
    boolean updateAccountPassword(Account account);
    boolean deleteUser(String id);

}
